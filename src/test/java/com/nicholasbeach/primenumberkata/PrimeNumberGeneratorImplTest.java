package com.nicholasbeach.primenumberkata;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PrimeNumberGeneratorImplTest {

    @Tested
    private PrimeNumberGeneratorImpl primeNumberGenerator;

    @Mocked
    private Primes primes;

    @Test
    public void isPrime_delegatesToApacheCommonsPrimes() {
        int input = 20;
        boolean expected = true;

        new Expectations() {{
            primes.isPrime(input);
            result = expected;
        }};

        boolean actual = primeNumberGenerator.isPrime(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generate_returnsOnlyPrimes() {
        new NonStrictExpectations() {{
            primes.isPrime(1);
            result = true;

            primes.isPrime(2);
            result = false;

            primes.isPrime(3);
            result = true;
        }};

        List<Integer> actual = primeNumberGenerator.generate(1, 3);
        assertContainsValues(actual, 1, 3);
    }

    @Test
    public void generate_returnsPrimesInOrder() {
        returnTrueForAllIsPrimeCalls();
        List<Integer> actual = primeNumberGenerator.generate(1, 3);
        assertContainsValuesInOrder(actual, 1, 2, 3);
    }

    @Test
    public void generate_acceptsReverseRanges() {
        returnTrueForAllIsPrimeCalls();
        List<Integer> actual = primeNumberGenerator.generate(3, 1);
        assertContainsValues(actual, 1, 2, 3);
    }

    @Test
    public void generate_returnsReverseRangeResultsInForwardOrder() {
        returnTrueForAllIsPrimeCalls();
        List<Integer> actual = primeNumberGenerator.generate(3, 1);
        assertContainsValuesInOrder(actual, 1, 2, 3);
    }

    private void assertContainsValuesInOrder(List<Integer> tested, Integer... values) {
        assertThat(tested.size()).isEqualTo(values.length);
        for(int i = 0; i < tested.size(); i++) {
            assertThat(tested.get(i)).isEqualTo(values[i]);
        }
    }

    private void assertContainsValues(List<Integer> tested, Integer... values) {
        assertThat(tested.size()).isEqualTo(values.length);
        for(Integer value : values) {
            assertThat(tested).contains(value);
        }
    }

    private void returnTrueForAllIsPrimeCalls() {
        new NonStrictExpectations() {{
            primes.isPrime(anyInt);
            result = true;
        }};
    }

}
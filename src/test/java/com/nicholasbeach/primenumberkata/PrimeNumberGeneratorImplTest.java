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

        assertThat(actual.size()).isEqualTo(2);
        assertThat(actual).contains(1);
        assertThat(actual).contains(3);
    }

    @Test
    public void generate_returnsPrimesInOrder() {
        new NonStrictExpectations() {{
            primes.isPrime(anyInt);
            result = true;
        }};

        List<Integer> actual = primeNumberGenerator.generate(1, 3);

        assertThat(actual.size()).isEqualTo(3);
        assertThat(actual.get(0)).isEqualTo(1);
        assertThat(actual.get(1)).isEqualTo(2);
        assertThat(actual.get(2)).isEqualTo(3);
    }

}
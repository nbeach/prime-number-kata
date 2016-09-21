package com.nicholasbeach.primenumberkata;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrimeNumberGeneratorImplTest {

    @Tested
    private com.nicholasbeach.primenumberkata.PrimeNumberGeneratorImpl primeNumberGenerator;

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

}
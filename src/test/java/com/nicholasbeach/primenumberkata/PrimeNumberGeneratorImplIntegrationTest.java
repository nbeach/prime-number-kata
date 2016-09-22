package com.nicholasbeach.primenumberkata;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PrimeNumberGeneratorImplIntegrationTest {

    private PrimeNumberGeneratorImpl primeNumberGenerator;

    @Before
    public void before() {
        primeNumberGenerator = new PrimeNumberGeneratorImpl();
    }

    @Test
    public void generate_CorrectlyDeterminesPrimes() {
        List<Integer> primes = primeNumberGenerator.generate(7900, 7920);
        assertThat(primes.size()).isEqualTo(3);
        assertThat(primes.get(0)).isEqualTo(7901);
        assertThat(primes.get(1)).isEqualTo(7907);
        assertThat(primes.get(2)).isEqualTo(7919);
    }

}

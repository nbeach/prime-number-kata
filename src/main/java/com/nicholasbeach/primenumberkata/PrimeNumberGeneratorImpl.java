package com.nicholasbeach.primenumberkata;

import org.apache.commons.math3.primes.Primes;

import java.util.List;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        return null;
    }

    @Override
    public boolean isPrime(int value) {
        return Primes.isPrime(value);
    }
}

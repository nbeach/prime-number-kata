package com.nicholasbeach.primenumberkata;

import org.apache.commons.math3.primes.Primes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        return IntStream
            .range(startingValue, endingValue + 1)
            .parallel()
            .boxed()
            .filter(this::isPrime)
            .collect(Collectors.toList());
    }

    @Override
    public boolean isPrime(int value) {
        return Primes.isPrime(value);
    }
}

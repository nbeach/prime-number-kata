package com.nicholasbeach.primenumberkata;

import org.apache.commons.math3.primes.Primes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        if(startingValue > endingValue) {
            int start = startingValue;
            startingValue = endingValue;
            endingValue = start;
        }

        return IntStream
            .range(startingValue, endingValue + 1)
            .parallel()
            .filter(this::isPrime)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public boolean isPrime(int value) {
        return Primes.isPrime(value);
    }
}

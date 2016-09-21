package com.nicholasbeach.primenumberkata;

import java.util.List;

public interface PrimeNumberGenerator {

    List<Integer> generate(int startingValue, int endingValue);
    boolean isPrime(int value);

}
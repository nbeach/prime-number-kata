package com.nicholasbeach.primenumberkata;

import java.util.List;

public class PrimeNumberGeneratorApp {

    public static void main(String[] args) {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGeneratorImpl();

        int start = Integer.valueOf(args[0]);
        int end = Integer.valueOf(args[1]);

        List<Integer> primes = primeNumberGenerator.generate(start, end);

        for(Integer prime : primes) {
            System.out.println(prime);
        }
    }
 }

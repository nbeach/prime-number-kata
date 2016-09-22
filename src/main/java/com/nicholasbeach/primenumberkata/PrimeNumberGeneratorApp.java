package com.nicholasbeach.primenumberkata;

public class PrimeNumberGeneratorApp {

    public static void main(String[] args) {
        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGeneratorImpl();

        int start = Integer.valueOf(args[0]);
        int end = Integer.valueOf(args[1]);

        primeNumberGenerator.generate(start, end);
    }
 }

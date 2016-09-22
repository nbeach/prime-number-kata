package com.nicholasbeach.primenumberkata;

import mockit.*;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumberGeneratorAppTest {

    @Mocked
    private PrimeNumberGeneratorImpl primeNumberGenerator;

    @Test
    public void main_PassesRangeArgumentsToGenerator() {
        int start = 5;
        int end = 10;

        new MockUp<PrimeNumberGeneratorImpl>() {
            @Mock
            public List<Integer> generate(int startingValue, int endingValue) {
                assertThat(startingValue).isEqualTo(start);
                assertThat(endingValue).isEqualTo(end);
                return new ArrayList<>();
            }
        };

        String[] args = {String.valueOf(start), String.valueOf(end)};
        PrimeNumberGeneratorApp.main(args);
    }

    @Test
    public void main_PrintPrimesInRangeToConsole(@Mocked PrintStream outputStream) {
        List<Integer> primes = Arrays.asList(1, 2, 3);

        new MockUp<PrimeNumberGeneratorImpl>() {
            @Mock
            public List<Integer> generate(int startingValue, int endingValue) {
                return primes;
            }
        };

        new Expectations() {{
            for(Integer prime : primes) {
                outputStream.println(prime);
            }
        }};

        System.setOut(outputStream);

        String[] args = {"1", "2"};
        PrimeNumberGeneratorApp.main(args);

        System.setOut(null);
    }


}
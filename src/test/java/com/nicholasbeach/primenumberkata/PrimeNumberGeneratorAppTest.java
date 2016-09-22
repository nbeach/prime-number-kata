package com.nicholasbeach.primenumberkata;

import mockit.*;
import org.junit.Test;

import java.util.ArrayList;
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


}
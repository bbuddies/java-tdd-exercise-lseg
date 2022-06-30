package com.odde.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeTest {
    Prime prime = new Prime();

    @Test
    public void no_prime_factor_for_1() {
        assertEquals(Arrays.asList(), prime.factors(1));
    }

    @Test
    public void prime_factors_for_2_is_2() {
        assertEquals(Arrays.asList(2), prime.factors(2));
    }

    @Test
    public void prime_factors_for_3_is_3() {
        assertEquals(Arrays.asList(3), prime.factors(3));
    }

    @Test
    public void prime_factors_for_4_are_2_and_2() {
        assertEquals(Arrays.asList(2, 2), prime.factors(4));
    }

    @Test
    public void prime_factors_for_6_are_2_and_3() {
        assertEquals(Arrays.asList(2, 3), prime.factors(6));
    }

    @Test
    public void prime_factors_for_8_are_2_2_and_2() {
        assertEquals(Arrays.asList(2, 2, 2), prime.factors(8));
    }

    @Test
    public void prime_factors_for_9_are_3_and_3() {
        assertEquals(Arrays.asList(3, 3), prime.factors(9));
    }
}

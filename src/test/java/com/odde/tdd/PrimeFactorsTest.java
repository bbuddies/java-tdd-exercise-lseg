package com.odde.tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PrimeFactorsTest {
    @Test
    public void invalid_num()
    {
        PrimeFactorization pf = new PrimeFactorization();
        ArrayList<Integer> result1 = pf.run(-1);
        ArrayList<Integer> result2 = pf.run(0);
        ArrayList<Integer> result3 = pf.run(1);
        assertEquals(Arrays.asList(), result1);
        assertEquals(Arrays.asList(), result2);
        assertEquals(Arrays.asList(), result3);
        return;
    }

    @Test
    public void prime_num()
    {
        PrimeFactorization pf = new PrimeFactorization();
        ArrayList<Integer> result1 = pf.run(2);
        ArrayList<Integer> result2 = pf.run(3);
        ArrayList<Integer> result3 = pf.run(17);
        assertEquals(Arrays.asList(2), result1);
        assertEquals(Arrays.asList(3), result2);
        assertEquals(Arrays.asList(17), result3);
        return;
    }

    @Test
    public void nonprime_num()
    {
        PrimeFactorization pf = new PrimeFactorization();
        ArrayList<Integer> result1 = pf.run(20);
        ArrayList<Integer> result2 = pf.run(456);
        ArrayList<Integer> result3 = pf.run(789);
        assertEquals(Arrays.asList(2,2,5), result1);
        assertEquals(Arrays.asList(2, 2, 2, 3, 19), result2);
        assertEquals(Arrays.asList(3, 263), result3);
        return;
    }
}

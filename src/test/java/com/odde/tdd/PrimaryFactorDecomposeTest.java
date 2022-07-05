package com.odde.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrimaryFactorDecomposeTest {

    @Test
    public void test_1() {
        Assert.assertEquals(Collections.emptyList(), PrimaryFactorDecompose.decompose_fast(1L));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(Collections.singletonList(2L), PrimaryFactorDecompose.decompose_fast(2L));
    }

    @Test
    public void test_3() {
        Assert.assertEquals(Collections.singletonList(3L), PrimaryFactorDecompose.decompose_fast(3L));
    }

    @Test
    public void test_4() {
        Assert.assertEquals(Arrays.asList(2L, 2L), PrimaryFactorDecompose.decompose_fast(4L));
    }

    @Test
    public void test_6() {
        Assert.assertEquals(Arrays.asList(2L, 3L), PrimaryFactorDecompose.decompose_fast(6L));
    }

    @Test
    public void test_26() {
        Assert.assertEquals(Arrays.asList(2L, 13L), PrimaryFactorDecompose.decompose_fast(26L));
    }

    @Test
    public void test_two_functions() {
        for(long i=1; i<10000; ++i) {
            List<Long> listA = PrimaryFactorDecompose.decompose(i);
            List<Long> listB = PrimaryFactorDecompose.decompose_fast(i);
            Assert.assertEquals(listA, listB);
        }
    }

    @Test
    public void test_decompose_big_number() {
        long startTime = System.nanoTime();
        List<Long> list = PrimaryFactorDecompose.decompose_fast(1232423232232321123L);
        System.out.println("elapsedTime: " + (System.nanoTime() - startTime));
        System.out.println("list: " + list);
    }

}
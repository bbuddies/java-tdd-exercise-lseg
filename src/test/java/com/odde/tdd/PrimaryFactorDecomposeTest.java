package com.odde.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class PrimaryFactorDecomposeTest {

    @Test
    public void test_is_primary() {
        Assert.assertTrue(PrimaryFactorDecompose.isPrimary(2));
        Assert.assertTrue(PrimaryFactorDecompose.isPrimary(3));
        Assert.assertTrue(PrimaryFactorDecompose.isPrimary(5));
        Assert.assertTrue(PrimaryFactorDecompose.isPrimary(29));
    }

    @Test
    public void test_is_not_primary() {
        Assert.assertFalse(PrimaryFactorDecompose.isPrimary(4));
        Assert.assertFalse(PrimaryFactorDecompose.isPrimary(77));
        Assert.assertFalse(PrimaryFactorDecompose.isPrimary(13 * 19));
    }


    @Test
    public void test_decompose_primary() {
        Assert.assertEquals(Collections.singletonList(2), PrimaryFactorDecompose.decompose(2));
        Assert.assertEquals(Collections.singletonList(13), PrimaryFactorDecompose.decompose(13));
    }

    @Test
    public void test_decompose_not_primary() {
        Assert.assertEquals(Collections.singletonList(2), PrimaryFactorDecompose.decompose(2));
        Assert.assertEquals(Collections.singletonList(13), PrimaryFactorDecompose.decompose(13));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_decompose_abnormal() {
        PrimaryFactorDecompose.decompose(0);
    }

}
package com.odde.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MathTest {
  private final Math target = new Math();

  @Test
  public void testNonPrimeNumber() {
    Assert.assertEquals("[]", Arrays.toString(target.decomposePrimeNumber(1)));
    Assert.assertEquals("[15733]", Arrays.toString(target.decomposePrimeNumber(15733)));
  }

  @Test
  public void testPrimeNumber() {
    Assert.assertEquals("[2]", Arrays.toString(target.decomposePrimeNumber(2)));
    Assert.assertEquals("[2, 2, 2]", Arrays.toString(target.decomposePrimeNumber(8)));
    Assert.assertEquals("[3, 3, 3, 37]", Arrays.toString(target.decomposePrimeNumber(999)));
  }
}
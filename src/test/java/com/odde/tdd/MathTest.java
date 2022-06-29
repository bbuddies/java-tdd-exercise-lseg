package com.odde.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MathTest {
  private final Math target = new Math();

  @Test
  public void hasNoPrimeNumber() {
    Assert.assertEquals("[]", Arrays.toString(target.getPrimeNumbers(1)));
  }

  @Test
  public void hasOnePrimeNumber() {
    Assert.assertEquals("[2]", Arrays.toString(target.getPrimeNumbers(2)));
    Assert.assertEquals("[2147483647]", Arrays.toString(target.getPrimeNumbers(2147483647)));
  }

  @Test
  public void hasMultiplePrimeNumbers() {
    Assert.assertEquals("[2, 2, 2]", Arrays.toString(target.getPrimeNumbers(8)));
    Assert.assertEquals("[3, 3, 3, 37]", Arrays.toString(target.getPrimeNumbers(999)));
  }
}
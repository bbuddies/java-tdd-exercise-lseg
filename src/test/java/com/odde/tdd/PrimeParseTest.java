package com.odde.tdd;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class PrimeParseTest {

  private PrimeParse primeParseUnderTest;

  @Before
  public void setUp() {
    primeParseUnderTest = new PrimeParse();
  }

  @Test
  public void testPrimeParse() {
    assertArrayEquals(new Integer[]{2}, primeParseUnderTest.primeParse(2));
    assertArrayEquals(new Integer[]{13}, primeParseUnderTest.primeParse(13));
    assertArrayEquals(new Integer[]{}, primeParseUnderTest.primeParse(1));
    assertArrayEquals(new Integer[]{}, primeParseUnderTest.primeParse(-1));
    assertArrayEquals(new Integer[]{2, 3}, primeParseUnderTest.primeParse(6));
    assertArrayEquals(new Integer[]{2, 2, 2}, primeParseUnderTest.primeParse(8));
    assertArrayEquals(new Integer[]{2, 3, 5}, primeParseUnderTest.primeParse(30));
  }
}

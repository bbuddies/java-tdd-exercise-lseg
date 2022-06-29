package com.odde.tdd;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {
  FizzBuzz target = new FizzBuzz();

  @Test
  public void testPositiveNumber() {
    Assert.assertEquals("Fizz", target.fizzBuzz(3));
    Assert.assertEquals("Fizz", target.fizzBuzz(6));
    Assert.assertEquals("Buzz", target.fizzBuzz(5));
    Assert.assertEquals("Buzz", target.fizzBuzz(10));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(15));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(30));

    Assert.assertEquals("Fizz", target.fizzBuzz(1324));
    Assert.assertEquals("Buzz", target.fizzBuzz(52));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(53));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(51));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(320));
  }

  @Test
  public void testNegativeNumber() {
    Assert.assertEquals("Fizz", target.fizzBuzz(-3));
    Assert.assertEquals("Fizz", target.fizzBuzz(-6));
    Assert.assertEquals("Buzz", target.fizzBuzz(-5));
    Assert.assertEquals("Buzz", target.fizzBuzz(-10));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(-15));
    Assert.assertEquals("FizzBuzz", target.fizzBuzz(-30));
  }

  @Test
  public void testNegativeNumber2() {
    Assert.assertEquals("-1", target.fizzBuzz(-1));
  }

  @Test
  public void testZero() {
    Assert.assertEquals("0", target.fizzBuzz(0));
  }
}
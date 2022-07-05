package com.odde.tdd;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest extends TestCase {
    @Test
    public void testFizzBuzz3() {
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(-3));
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(13));
        Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(33));
    }

    @Test
    public void testFizzBuzz5() {
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
        Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(151));
    }

    @Test
    public void testFizzBuzz3And5() {
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(0));
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(60));
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(35));
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
        Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(51));
    }

    @Test
    public void testFizzBuzzNumber() {
        Assert.assertEquals("2", FizzBuzz.fizzBuzz(2));
        Assert.assertEquals("8", FizzBuzz.fizzBuzz(8));
        Assert.assertEquals("-8", FizzBuzz.fizzBuzz(-8));
    }

}
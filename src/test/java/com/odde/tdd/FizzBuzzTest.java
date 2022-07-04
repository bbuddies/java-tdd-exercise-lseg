package com.odde.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

  FizzBuzz fizzBuzz = new FizzBuzz();

//  @Before
//  public void setup()
//  {fizzBuzz= new FizzBuzz();}

  @Test
  public void input_should_bigger_than_0() {
    assertEquals("error", fizzBuzz.FizzBuzz(-3));
  }
//    String result = fizzBuzz.FizzBuzz(1);
//    assertEquals("1", result);

  @Test
  public void normal_number() {
    assertEquals("1", fizzBuzz.FizzBuzz(1));
  }

  @Test
  public void fizz() {

    assertEquals("Fizz", fizzBuzz.FizzBuzz(3));
  }

  @Test
  public void buzz() {

    assertEquals("Buzz", fizzBuzz.FizzBuzz(5));

  }
  @Test
  public void fizzbuzz() {

    assertEquals("FizzBuzz", fizzBuzz.FizzBuzz(15));
  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
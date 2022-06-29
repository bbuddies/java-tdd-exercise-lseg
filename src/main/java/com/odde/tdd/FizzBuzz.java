package com.odde.tdd;

public class FizzBuzz {
  public String fizzBuzz(int number) {
    if (number == 0) {
      return "0";
    } else if ((times3(number) && times5(number)) ||
        (times3(number) && contains(number, "5")) ||
        (times5(number) && contains(number, "3")) ||
        (contains(number, "3") && contains(number, "5"))) {
      return "FizzBuzz";
    } else if (times5(number) || contains(number, "5")) {
      return "Buzz";
    } else if (times3(number) || contains(number, "3")) {
      return "Fizz";
    } else {
      return String.valueOf(number);
    }
  }

  private boolean contains(int number, String contain) {
    return String.valueOf(number).contains(contain);
  }

  private boolean times3(int number) {
    return number % 3 == 0;
  }

  private boolean times5(int number) {
    return number % 5 == 0;
  }
}


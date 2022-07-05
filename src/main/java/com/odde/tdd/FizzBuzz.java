package com.odde.tdd;

public class FizzBuzz {
    public static String fizzBuzz(int n) {
//        if(n <= 0) {
//            return "";
//        }
        String nStr = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        if((n % 3 == 0) || nStr.contains("3")) {
            sb.append("Fizz");
        }
        if(n % 5 == 0 || nStr.contains("5")) {
            sb.append("Buzz");
        }
        if(sb.length() == 0) {
            sb.append(n);
        }
        return sb.toString();
    }
}

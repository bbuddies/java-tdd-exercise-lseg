package com.odde.tdd;

import java.util.ArrayList;
import java.util.List;

public class PrimeParse {
  Integer[] primeParse(int num) {

    List<Integer> testList = new ArrayList<>();
    Integer[] arr;

    if(num <= 1) {
      arr = new Integer[ testList.size() ];
      return testList.toArray(arr);
    }
    while(num > 1) {
      for(int i = 2; i <= num; i ++) {
        if(num % i == 0) {
          testList.add(i);
          num = num/i;
          break;
        }
      }
    }

    arr = new Integer[ testList.size() ];
    return testList.toArray(arr);

  }
}

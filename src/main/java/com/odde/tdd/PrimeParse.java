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
    int j = 2;
    while(num > 1) {
      for(int i = j; i <= num; i ++) {
        if(num % i == 0) {
          testList.add(i);
          num = num/i;
          j = i;
          break;
        }
      }
    }

    arr = new Integer[ testList.size() ];
    return testList.toArray(arr);

  }
}

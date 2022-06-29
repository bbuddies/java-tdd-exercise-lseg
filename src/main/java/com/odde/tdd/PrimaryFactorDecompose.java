package com.odde.tdd;

import java.util.ArrayList;
import java.util.List;

public class PrimaryFactorDecompose {
    public static boolean isPrimary(int n) {
        int m = n/2;
        for(int i=2; i<=m; ++i) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> decompose(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("the input number (" + n + ") should be greater than 0");
        }
        List<Integer> primaryFactorList = new ArrayList<>();
        if (n > 1) {
            for(int i=2; i<=n; ++i) {
                if(isPrimary(i)) {
                    while(n % i == 0) {
                        primaryFactorList.add(i);
                        n = n / i;
                    }
                }
            }
        }
        return primaryFactorList;
    }
}

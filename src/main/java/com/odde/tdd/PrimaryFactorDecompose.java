package com.odde.tdd;

import java.util.ArrayList;
import java.util.List;

public class PrimaryFactorDecompose {

    public static List<Long> decompose_fast(long n) {
        List<Long> factors = new ArrayList<>();
        long m = (long)(Math.sqrt(n));
        for (long i = 2; i <= m && i <= n; ++i) {
            while(n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }
        if(n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static List<Long> decompose(long n) {
        List<Long> factors = new ArrayList<>();
        for(long i=2; n>1; ++i) {
            for(; n % i == 0; n = n / i) {
                factors.add(i);
            }
        }
        return factors;
    }

}

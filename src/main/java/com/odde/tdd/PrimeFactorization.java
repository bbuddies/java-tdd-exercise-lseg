package com.odde.tdd;

import java.util.ArrayList;

public class PrimeFactorization {
    public ArrayList<Integer> run(int n)
    {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        //invalid cases
        if( n < 2 )
            return factors;

        //take 2 out to speed up
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        //the last one
        if (n > 1)
            factors.add(n);

        return factors;
    }
}

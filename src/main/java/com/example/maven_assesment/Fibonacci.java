package com.example.maven_assesment;

import java.util.ArrayList;
import java.util.List;

  class Fibonacci {

      static List<Integer> generateFibonacci(int nterms) {
        List<Integer> sequence = new ArrayList<>();
        
        if (nterms <= 0) {
            throw new IllegalArgumentException("Please enter a positive integer");
        } else if (nterms == 1) {
            sequence.add(0);
        } else {
            int n1 = 0;
           int n2 = 1;
            for (int count = 0; count < nterms; count++) {
                sequence.add(n1);
                int nth = n1 + n2;
                n1 = n2;
                n2 = nth;
            }
           
        }
        return sequence;
    }


}

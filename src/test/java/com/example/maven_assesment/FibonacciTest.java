package com.example.maven_assesment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class FibonacciTest {

    @Test
     void testNegativeTerms() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Fibonacci.generateFibonacci(-5);
        });
        assertEquals("Please enter a positive integer", thrown.getMessage());
    }

    @Test
     void testZeroTerms() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Fibonacci.generateFibonacci(0);
        });
        assertEquals("Please enter a positive integer", thrown.getMessage());
    }

    @Test
     void testOneTerm() {
        List<Integer> result = Fibonacci.generateFibonacci(1);
        assertEquals(List.of(0), result);
    }

    @Test
     void testMultipleTerms() {
        List<Integer> result = Fibonacci.generateFibonacci(5);
        assertEquals(List.of(0, 1, 1, 2, 3), result);
    }

    @Test
     void testLargeNumberOfTerms() {
        List<Integer> result = Fibonacci.generateFibonacci(10);
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), result);
    }
}

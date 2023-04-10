package com.datvutech.junit.util;

public class NumberUtils {
    public static boolean isPrime(long x) {
        if (x < 1) {
            throw new ArithmeticException("The input number must be bigger than 0!");
        }
        /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return x > 1;
    }
}

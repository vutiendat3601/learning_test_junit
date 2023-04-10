package com.datvutech.junit;

import com.datvutech.junit.util.NumberUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 6, 4, 8, 9, 11 };
        int sum = 0;
        for (int i : nums) {
            if (NumberUtils.isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

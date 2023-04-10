package com.datvutech.junit.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("Before All NumberUtilsTest!");
        boolean e = Files.exists(Paths.get("src/test/resources/prime-numbers.csv"));
        System.out.println("existence: " + e);
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("After All NumberUtilsTest!");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Before Each NumberUtilsTest!");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("After Each NumberUtilsTest!");
    }

    @Test
    public void testEvenNumber() {
        long x = 2;

        boolean expected = true;

        boolean actual = NumberUtils.isPrime(x);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testOddNumber() {
        long x = 5;

        boolean expected = true;

        boolean actual = NumberUtils.isPrime(x);

        Assertions.assertEquals(expected, actual);
    }

    @ValueSource(longs = { 2, 3, 5, 7, 11, 17, 23 })
    @ParameterizedTest
    public void testPrimeNumbers(long x) {
        Assertions.assertTrue(NumberUtils.isPrime(x), x + " is wrong");
    }

    @CsvSource({ "1,false", "17,true", "16,false", "31,true" })
    @ParameterizedTest
    public void testPrimeNumbers(long x, boolean expected) {
        Assertions.assertEquals(expected, NumberUtils.isPrime(x));
    }

    @CsvFileSource(files = "src/test/resources/prime-numbers.csv", numLinesToSkip = 0)
    @ParameterizedTest
    public void testPrimeNumbersFromCsvFile(long x, boolean expected) {

        Assertions.assertEquals(expected, NumberUtils.isPrime(x));
    }

    @Test
    public void testLessThanOneException() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> NumberUtils.isPrime(0));
    }

    @Test
    public void testTimeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(10_000L),
                () -> NumberUtils.isPrime(1_000_000_000_000_000L));
    }
}

package com.cbt.utilities;

public class StringUtility {
    public static String verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            return "PASS";
        } else {
            return "FAIL \nExpected: " + expected + "\nActual: " + actual;
        }
    }

    public static void verifyStartsWith(String expected, String actual) {
        if (actual.startsWith(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
    }
}

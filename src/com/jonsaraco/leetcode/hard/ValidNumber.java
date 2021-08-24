package com.jonsaraco.leetcode.hard;

/**
 * A valid number can be split up into these components (in order):
 * <p>
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * <p>
 * A decimal number can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * One or more digits, followed by a dot '.'.
 * One or more digits, followed by a dot '.', followed by one or more digits.
 * A dot '.', followed by one or more digits.
 * <p>
 * An integer can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * One or more digits.
 * <p>
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 * <p>
 * Given a string s, return true if s is a valid number.
 */

public class ValidNumber {

    /**
     * Speed beats 36.6% of solutions, memory usage beats 34.95% of solutions.
     */

    public static boolean isNumber(String s) {
        if (s.isEmpty()) return false;
        try {
            validateNumber(s, false);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void validateNumber(String s, boolean mantissa) {
        boolean noMoreSigns = false;
        boolean noMoreDecimals = false;
        boolean numberFound = false;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '-' || character == '+') {
                if (noMoreSigns) throw new IllegalStateException();
                noMoreSigns = true;
            } else if (character == '.') {
                if (mantissa || noMoreDecimals) throw new IllegalStateException();
                noMoreSigns = true;
                noMoreDecimals = true;
            } else if (character == 'e' || character == 'E') {
                if (!numberFound || mantissa) {
                    throw new IllegalStateException();
                } else {
                    validateNumber(s.substring(i + 1), true);
                    break;
                }
            } else {
                if (Character.isDigit(character)) {
                    noMoreSigns = true;
                    numberFound = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        // This ""number"" didn't even have any numbers in it
        if (!numberFound) {
            throw new IllegalStateException();
        }
    }

    public static void main(String[] args) {
        String hello = "005047e+6";
        System.out.println(isNumber(hello));
    }
}

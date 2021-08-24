package com.company.leetcode.easy;

/**
 * Results:
 *
 * With string conversion:
 * Runtime: 7 ms, faster than 66.70% of Java online submissions for Palindrome Number.
 * Memory Usage: 38.5 MB, less than 42.08% of Java online submissions for Palindrome Number.
 *
 * Without:
 * Runtime: 11ms
 */

public class PalindromeNumber {

    public boolean isPalindromeConvert(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String numberAsString = String.valueOf(x);
        int left = 0;
        int right = numberAsString.length() - 1;
        while (numberAsString.charAt(left) == numberAsString.charAt(right)) {
            if (right - left <= 1) return true;
            left++;
            right--;
        }
        return false;
    }

    public static boolean isPalindromeNoConvert(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int left = 0;
        int right = largestPowerOfTenLessThan(x);
        while (Math.floor(x/Math.pow(10, left) % 10) ==
                Math.floor(x / Math.pow(10, right) % 10)) {
            if (right - left <= 1) return true;
            left++;
            right--;
        }
        return false;
    }

    private static int largestPowerOfTenLessThan(int x) {
        int i=1;
        while(Math.pow(10, i + 1) <= x) {
            i++;
        }
        return i;
    }
}

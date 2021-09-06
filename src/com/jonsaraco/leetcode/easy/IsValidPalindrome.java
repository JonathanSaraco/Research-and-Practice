package com.jonsaraco.leetcode.easy;

/**
 * Runtime: 2 ms, faster than 98.33% of Java online submissions for Valid Palindrome.
 * Memory Usage: 39.1 MB, less than 72.83% of Java online submissions for Valid Palindrome.
 */
public class IsValidPalindrome {

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (right - left > 0) {
            char leftCh = Character.toLowerCase(s.charAt(left));
            char rightCh = Character.toLowerCase(s.charAt(right));
            if (!Character.isLetterOrDigit(leftCh)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightCh)) {
                right--;
            } else {
                if (leftCh != rightCh) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

}

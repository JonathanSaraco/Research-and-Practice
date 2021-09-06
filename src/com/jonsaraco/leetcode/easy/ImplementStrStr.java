package com.jonsaraco.leetcode.easy;

public class ImplementStrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int numCharacters = haystack.length();
        for (int i=0; i < numCharacters; i++) {
            if (numCharacters - i < needle.length()) return -1;
            if (haystack.charAt(i) == needle.charAt(0)) {
                // This is the start of a prospective needle location
                if (haystack.startsWith(needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

}

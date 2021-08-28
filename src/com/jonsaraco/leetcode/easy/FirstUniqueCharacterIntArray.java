package com.jonsaraco.leetcode.easy;

/**
 * Runtime: 7 ms, faster than 87.21% of Java online submissions for First Unique Character in a String.
 * Memory Usage: 39.5 MB, less than 64.05% of Java online submissions for First Unique Character in a String.
 */
public class FirstUniqueCharacterIntArray {
    public static void main(String[] args) {
        String test = "aaabccc";
        System.out.println(firstUniqChar(test));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i=0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}

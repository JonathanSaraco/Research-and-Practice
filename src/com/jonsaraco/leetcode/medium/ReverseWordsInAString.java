package com.jonsaraco.leetcode.medium;

import java.util.Stack;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    /**
     * Runtime: 6 ms, faster than 72.96% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 41.3 MB, less than 26.68% of Java online submissions for Reverse Words in a String.
     */
    public static String reverseWords(String s) {
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();
        for (int i=s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (!wordBuilder.toString().isEmpty()) {
                    resultBuilder.append(wordBuilder.reverse())
                            .append(' ');
                    wordBuilder = new StringBuilder();
                }
            } else {
                wordBuilder.append(ch);
            }
        }
        if (!wordBuilder.toString().isEmpty()) {
            resultBuilder.append(wordBuilder.reverse());
        }
        return resultBuilder.toString().trim();
    }

    /**
     * Runtime: 11 ms, faster than 41.48% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 43.3 MB, less than 14.75% of Java online submissions for Reverse Words in a String.
     */
    private static String reverseWordsFirstAttempt(String s) {
        s = s.trim();
        Stack<String> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                String word = sb.toString();
                if (!word.trim().isEmpty()) {
                    stringStack.push(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        if (!sb.toString().isEmpty()) {
            stringStack.push(sb.toString());
        }
        // Return the new string
        StringBuilder resultBuilder = new StringBuilder();
        while (true) {
            String word = stringStack.pop();
            resultBuilder.append(word);
            if (stringStack.isEmpty()) {
                break;
            }
            resultBuilder.append(' ');
        }
        return resultBuilder.toString();
    }

}

package com.company.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Results:
 *
 * Runtime: 205 ms, faster than 6.87% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.9 MB, less than 16.43% of Java online submissions for Longest Substring Without Repeating Characters.
 */

public class LongestSubStringNoRepeats {

    public static void main(String[] args) {
        String string = "wobgrovw";
        System.out.println(lengthOfLongestSubstring(string));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        String longestSubString = "";
        String currentSubString = "";
        Set<String> charactersEncountered = new HashSet<>();
        outerLoop: for (int i = 0; i < s.length();) {
            // Don't continue if we don't have enough characters left
            currentSubString = currentSubString + String.valueOf(s.charAt(i));
            charactersEncountered.add(String.valueOf(s.charAt(i)));
            if (longestSubString.isEmpty()) {
                longestSubString = currentSubString;
            }
            for (int j = i + 1; j < s.length(); j++) {
                String character = String.valueOf(s.charAt(j));
                if (!charactersEncountered.contains(character)) {
                    currentSubString = String.format("%s%s", currentSubString, character);
                    charactersEncountered.add(character);
                    if (currentSubString.length() > longestSubString.length()) {
                        longestSubString = currentSubString;
                    }
                } else {
                    charactersEncountered.remove(character);
                    currentSubString = currentSubString.substring(currentSubString.indexOf(character) + 1);
                    String finalCurrentSubString = currentSubString;
                    charactersEncountered.removeIf(value -> !finalCurrentSubString.contains(value));
                    if (currentSubString.isEmpty()) {
                        charactersEncountered.clear();
                    }
                    i = j;
                    continue outerLoop;
                }
            }
            i++;
        }
        return longestSubString.length();
    }
}

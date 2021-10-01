package com.jonsaraco.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        String s = "aaabbbcc";
        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s) {
        // Count the frequencies
        int[] charFrequencies = new int[26];
        for (int i=0; i < s.length(); i++) {
            charFrequencies[s.charAt(i) - 'a']++;
        }
        // Use a hashset to find a frequency we didn't have before
        Set<Integer> frequencies = new HashSet<>();
        int charactersDeleted = 0;
        for (int i=0; i < 26; i++) {
            int freq = charFrequencies[i];
            while (freq != 0 && frequencies.contains(freq)) {
                freq--;
                charactersDeleted++;
            }
            frequencies.add(freq);
        }
        return charactersDeleted;
    }
}

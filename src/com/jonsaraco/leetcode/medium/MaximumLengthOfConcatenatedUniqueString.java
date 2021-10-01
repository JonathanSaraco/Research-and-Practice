package com.jonsaraco.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfConcatenatedUniqueString {

    private int result = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String s, int index) {
        if (isAllUnique(s)) {
            result = Math.max(result, s.length());
        } else {
            return;
        }
        for (int i=index; i < arr.size(); i++) {
            dfs(arr, s + arr.get(i), i);
        }
    }

    private boolean isAllUnique(String s) {
        Set<Character> characters = new HashSet<>();
        for (int i=0; i < s.length(); i++) {
            if (!characters.add(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}

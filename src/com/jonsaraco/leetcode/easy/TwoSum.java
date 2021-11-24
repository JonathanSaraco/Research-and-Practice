package com.jonsaraco.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Runtime: 1 ms, faster than 99.68% of Java online submissions for Two Sum.
     * Memory Usage: 39.7 MB, less than 38.14% of Java online submissions for Two Sum.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementMap.containsKey(nums[i])) {
                return new int[]{i, complementMap.get(nums[i])};
            }
            complementMap.put(complement, i);
        }
        throw new IllegalStateException("No solution.");
    }

}

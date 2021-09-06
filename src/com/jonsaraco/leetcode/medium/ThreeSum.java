package com.jonsaraco.leetcode.medium;

import java.util.*;

/**
 * IN PROGRESS
 */
public class ThreeSum {

    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};

        System.out.println(threeSum(nums));
    }

    // Too SLOW
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Set<Integer>> foundCombos = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int target = -number;
            Map<Integer, Integer> complementIndexMap = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (complementIndexMap.containsKey(nums[j])) {
                        List<Integer> newList = List.of(number, nums[j], nums[complementIndexMap.get(nums[j])]);
                        Set<Integer> newSet = new HashSet<>(newList);
                        if (!foundCombos.contains(newSet)) {
                            foundCombos.add(newSet);
                            result.add(newList);
                        }
                    } else {
                        complementIndexMap.put(target - nums[j], j);
                    }
                }
            }
        }
        return result;
    }
}

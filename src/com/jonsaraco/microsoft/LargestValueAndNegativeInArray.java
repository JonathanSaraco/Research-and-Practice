package com.jonsaraco.microsoft;

import java.util.HashSet;
import java.util.Set;

public class LargestValueAndNegativeInArray {

    public static void main(String[] args) {
        int[] nums = {1, -1, 2, 3, -4, 4};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        Set<Integer> numbersFound = new HashSet<>();
        int biggestNumberPassesTest = 0;
        for (int i=0; i < nums.length; i++) {
            int num = nums[i];
            numbersFound.add(num);
            if (numbersFound.contains(num) && numbersFound.contains(-num)) {
                biggestNumberPassesTest = Math.max(biggestNumberPassesTest, Math.abs(num));
            }
        }
        return biggestNumberPassesTest;
    }
}

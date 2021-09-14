package com.jonsaraco.leetcode.easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int minIndex = 0;
        int maxIndex = nums.length - 1;
        while (maxIndex - minIndex >= 0) {
            int middleIndex = minIndex + (maxIndex - minIndex) / 2;
            if (nums[middleIndex] == target) return middleIndex;
            if (target < nums[middleIndex]) {
                maxIndex = middleIndex - 1;
            } else {
                minIndex = middleIndex + 1;
            }
        }
        return -1;
    }
}

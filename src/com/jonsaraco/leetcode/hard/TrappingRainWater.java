package com.jonsaraco.leetcode.hard;

import java.util.Arrays;

/**
 * Runtime: 1 ms, faster than 84.69% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 39 MB, less than 22.36% of Java online submissions for Trapping Rain Water.
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 2, 3, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height.length <= 1) return 0;
        //Find the left most area where a pool can start (first node where there's a decrease)
        int left = 0;
        while (height[left + 1] >= height[left]) {
            left++;
            if (left == height.length - 1) return 0;
        }
        // Find the right most area where a pool can end (first node from the right where there's a decrease)
        int right = height.length - 1;
        while (height[right - 1] >= height[right]) {
            right--;
            if (right == 0) return 0;
        }
        // Find pools from left to right
        int trapped = 0;
        Integer potentialWall = null;
        int startOfPool = left;
        for (int i = left + 1; i <= right; i++) {
            int currentHeight = height[i];
            if (height[i - 1] < currentHeight && currentHeight >= (potentialWall != null ? height[potentialWall] : 0)) {
                potentialWall = i;
            }
            // We have finished a pool
            if (currentHeight >= height[startOfPool] || i == right) {
                if (i < right) {
                    trapped += calculateTrapped(startOfPool, i, height);
                } else {
                    if (height[potentialWall] > height[i]) {
                        trapped += calculateTrapped(startOfPool, potentialWall, height);
                        trapped += trap(Arrays.copyOfRange(height, potentialWall, i+1));
                    } else {
                        trapped += calculateTrapped(startOfPool, i, height);
                    }
                }
                startOfPool = i;
                potentialWall = null;
            }
        }
        // If we have a pool that hasn't been finished yet, do that now
        if (potentialWall != null) {
            trapped += calculateTrapped(startOfPool, potentialWall, height);
        }
        return trapped;
    }

    private static int calculateTrapped(int startOfPool, int endOfPool, int[] height) {
        int trapped = 0;
        int poolHeight = Math.min(height[startOfPool], height[endOfPool]);
        for (int i = startOfPool + 1; i < endOfPool; i++) {
            trapped += Math.max(0, poolHeight - height[i]);
        }
        return trapped;
    }
}

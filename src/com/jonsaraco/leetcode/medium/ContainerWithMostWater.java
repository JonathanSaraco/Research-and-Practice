package com.jonsaraco.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Container With Most Water.
 * Memory Usage: 54.1 MB, less than 13.55% of Java online submissions for Container With Most Water.
 */
public class ContainerWithMostWater {

    private int maxArea = 0;

    public int maxArea(int[] height) {
        findMaxArea(0, height.length - 1, height);
        return maxArea;
    }

    public void findMaxArea(int left, int right, int[] height) {
        int area = (right - left) * Math.min(height[left], height[right]);
        if (area > maxArea) {
            maxArea = area;
        }
        if (height[left] < height[right]) {
            // Find new left bound
            int newLeft = left + 1;
            while (newLeft < height.length && height[newLeft] <= height[left]) {
                newLeft++;
            }
            if (newLeft < height.length) {
                findMaxArea(newLeft, right, height);
            }
        } else {
            // Find new right bound
            int newRight = right - 1;
            while (newRight >= 0 && height[newRight] <= height[right]) {
                newRight--;
            }
            if (newRight >= 0) {
                findMaxArea(left, newRight, height);
            }
        }

        Map<Integer, int[]> integerMap = new HashMap<>();
    }

}

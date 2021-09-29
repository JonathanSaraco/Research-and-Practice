package com.jonsaraco.leetcode.medium;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 38.4 MB, less than 57.42% of Java online submissions for Search in Rotated Sorted Array.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        // Array is not rotated, just do normal BST
        if (nums[0] < nums[nums.length - 1]) return binarySearch(nums, 0, nums.length - 1, target);
        // Find rotation point and BST left or right side
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            if (nums[left] > nums[left + 1]) {
                return binarySearch(nums, left + 1, nums.length - 1, target);
            }
            if (nums[right] < nums[right - 1]) {
                return binarySearch(nums, 0, right - 1, target);
            }
            left++;
            right--;
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        if (endIndex - startIndex < 0) return -1;
        int newIndex = startIndex + (endIndex - startIndex) / 2;
        int newValue = nums[newIndex];
        if (newValue == target) {
            return newIndex;
        } else if (newValue < target) {
            return binarySearch(nums, newIndex + 1, endIndex, target);
        } else {
            return binarySearch(nums, startIndex, newIndex - 1, target);
        }
    }

}

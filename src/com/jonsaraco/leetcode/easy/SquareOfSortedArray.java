package com.jonsaraco.leetcode.easy;

import java.util.Arrays;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
 * Memory Usage: 40.9 MB, less than 43.44% of Java online submissions for Squares of a Sorted Array.
 *
 * I WROTE THIS CODE, BUT I DID NOT COME UP WITH THE IDEA
 * Lesson learned: Exploit the fact that the array is sorted in increasing order, and that the square function is
 * symmetric. The last entry in the sorted array is either going to come from the 0th index, or the n-1th index.
 * Determine which is the n-1th index, then increment/decrement your pointers coming from opposite ends.
 */
public class SquareOfSortedArray {

    public static void main(String[] args) {
        int[] test = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(test)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sortedSquares = new int[nums.length];
        for (int i=0; i < n; i++) {
            int square = nums[i]*nums[i];
            int j = n - 1;
            while(square < sortedSquares[j] && j > 0) {
                j--;
            }
            for (int k = 0; k < j; k++) {
                sortedSquares[k] = sortedSquares[k+1];
            }
            sortedSquares[j] = square;
        }
        return sortedSquares;
    }
}

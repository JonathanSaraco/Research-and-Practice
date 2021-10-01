package com.jonsaraco.leetcode.easy;

public class FindNUniqueIntegersSumToZero {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int num = right;
            result[left++] = -num;
            result[right--] = num;
        }
        return result;
    }

}

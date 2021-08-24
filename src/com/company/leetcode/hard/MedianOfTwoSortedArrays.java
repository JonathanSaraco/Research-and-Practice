package com.company.leetcode.hard;

/**
 * Runtime: 2 ms, faster than 99.88% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 40.3 MB, less than 54.17% of Java online submissions for Median of Two Sorted Arrays.
 */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
//
        char[] characters = {'a','b','c','d'};
        for (int i=0; i < characters.length; i++) {
            System.out.println(String.valueOf(characters[i]) + " becomes this: " + String.valueOf(characters[i] - 'a'));
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int sumOfLengths = nums1.length + nums2.length;
        boolean evenElements = sumOfLengths % 2 == 0;
        int medianIndex = (int) Math.floor(sumOfLengths / 2.);
        if (evenElements) {
            medianIndex--;
        }
        double median = 0.;
        while (true) {
            int currentNum;
            int num1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int num2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            if (num1 < num2) {
                currentNum = num1;
                p1++;
            } else {
                currentNum = num2;
                p2++;
            }
            if (p1 + p2 == medianIndex + 1) {
                median += currentNum;
                if (!evenElements) {
                    break;
                }
            }
            if (evenElements && p1 + p2 == medianIndex + 2) {
                median += currentNum;
                break;
            }
        }
        if (evenElements) {
            return median / 2.;
        } else {
            return median;
        }
    }
}

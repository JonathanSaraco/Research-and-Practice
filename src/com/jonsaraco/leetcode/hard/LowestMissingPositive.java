package com.jonsaraco.leetcode.hard;

import java.util.Iterator;
import java.util.TreeSet;

public class LowestMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }

    /**
     * Runtime: 199 ms, faster than 5.09% of Java online submissions for First Missing Positive.
     * Memory Usage: 163.9 MB, less than 5.01% of Java online submissions for First Missing Positive.
     * Very bad attempt, but at least it solves the problem.
     */
    private static int firstMissingPositive(int[] nums) {
        TreeSet<Integer> numbers = new TreeSet<>();
        for (int num : nums) {
            if (num > 0) {
                numbers.add(num);
            }
        }
        if (numbers.isEmpty()) {
            return 1;
        }
        Iterator<Integer> iter = numbers.iterator();
        int num1 = iter.next(), num2;
        if (num1 > 1) {
            return 1;
        }
        while (iter.hasNext()) {
            num2 = iter.next();
            if (num2 - num1 > 1) {
                return num1 + 1;
            }
            num1 = num2;
        }
        return num1 + 1;
    }

}

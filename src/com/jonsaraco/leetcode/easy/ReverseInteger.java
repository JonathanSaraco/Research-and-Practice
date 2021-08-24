package com.jonsaraco.leetcode.easy;

public class ReverseInteger {

    public static int reverseInteger(int x) {
        int sign = x < 0 ? -1 : 1;
        String reversedString = new StringBuffer().append(sign * x).reverse().toString();
        try {
            return sign * Integer.parseInt(reversedString);
        } catch (Exception e) {
            return 0;
        }
    }


    public static void main(String[] args) {
        int test = -123;
        System.out.println(reverseInteger(test));
    }
}

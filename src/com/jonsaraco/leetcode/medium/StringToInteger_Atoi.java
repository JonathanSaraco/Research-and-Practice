package com.jonsaraco.leetcode.medium;

public class StringToInteger_Atoi {

    public static int myAtoi(String s) {
        String trimmed = trimLeadingWhitespace(s);
        // Check trivial case
        if (s.isEmpty()) return 0;
        int sign = 1;
        // Get sign of result, and trim the sign away if needed
        switch(trimmed.charAt(0)) {
            case '-':
                sign = -1;
            case '+':
                trimmed = trimmed.substring(1);
                break;
        }
        // Build integer result
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i < trimmed.length(); i++) {
            try {
                int digit = Integer.parseInt(String.valueOf(trimmed.charAt(i)));
                stringBuffer.append(digit);
            } catch (Exception e) {
                // No more digits
                break;
            }
            // Attempt to parse integer
            try {
                Integer.valueOf(stringBuffer.toString());
            } catch (Exception e) {
                // Integer is out of bounds
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        try {
            return sign * Integer.parseInt(stringBuffer.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    private static String trimLeadingWhitespace(String s) {
        char whitespaceChar = ' ';
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) != whitespaceChar) {
                return s.substring(i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String test = " ";
        System.out.println(myAtoi(test));
    }
}

package com.jonsaraco.leetcode.easy;

import java.util.Map;

/**
 * Results:
 *
 * Runtime: 6 ms, faster than 29.63% of Java online submissions for Roman to Integer.
 * Memory Usage: 39.2 MB, less than 64.56% of Java online submissions for Roman to Integer.
 */
public class RomanToInt {

    private static final Map<String, Integer> ROMAN_NUMERAL_MAP = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000);

    private static final Map<String, Integer> SUBTRACTION_MAP = Map.of(
            "IV", 4,
            "IX", 9,
            "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM", 900);

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            switch (c) {
                case "I":
                case "X":
                case "C":
                    // If this isn't the last character, check if it's a subtraction
                    if (i < s.length() - 1) {
                        String cNext = String.valueOf(s.charAt(i + 1));
                        if (SUBTRACTION_MAP.containsKey(c + cNext)) {
                            i++;
                            result += SUBTRACTION_MAP.get(c + cNext);
                        } else {
                            result += ROMAN_NUMERAL_MAP.get(c);
                        }
                    } else {
                        result += ROMAN_NUMERAL_MAP.get(c);
                    }
                    break;
                default:
                    result += ROMAN_NUMERAL_MAP.get(c);
            }
        }
        return result;
    }
}

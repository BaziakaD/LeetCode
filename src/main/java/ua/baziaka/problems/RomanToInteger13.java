package ua.baziaka.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger13 {

    static Map<Character, Integer> romans;

    static {

        romans = new HashMap<>();

        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }

    public int romanToInt(String input) {

        int acc = 0;

        char[] chars = input.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            int val = romans.get(chars[i]);

            if (i < chars.length - 1 && val < romans.get(chars[i + 1])) {
                acc -= val;
            } else {
                acc += val;
            }
        }

        return acc;
    }
}


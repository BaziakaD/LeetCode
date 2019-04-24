package ua.baziaka.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    private List<Character> characterSet;

    public LongestSubstringWithoutRepeatingCharacters3() {
        characterSet = new LinkedList<>();
    }

    public int lengthOfLongestSubstring(String input) {

        char[] chars = input.toCharArray();
        int length = 0;

        for (int i = 0; i < chars.length; i++) {

            if (characterSet.contains(chars[i])) {

                int setSize = characterSet.size();
                if (setSize > length) {
                    length = setSize;
                }

                while (!characterSet.isEmpty() && characterSet.contains(chars[i])) {
                    characterSet.remove(0);
                }
            }
            characterSet.add(chars[i]);
        }

        return length > characterSet.size() ? length : characterSet.size();
    }
}

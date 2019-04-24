package ua.baziaka.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring5 {

    private String palindrome = "";
    private Set<Character> usedChars;

    public LongestPalindromicSubstring5() {
        usedChars = new HashSet<>();
    }

    public String longestPalindrome(String input) {

        if (input.isEmpty() || input.length() == 1) {
            return input;
        }

        for (int i = 0; i < input.length(); i++) {

            if (usedChars.contains(input.charAt(i))) {
                continue;
            }

            int l = i;

            while (true) {
                int r = input.length();
                while (true) {
                    r = input.lastIndexOf(input.charAt(i), r);

                    if (r == -1) {
                        break;
                    }

                    if (r + 1 - l < palindrome.length()) {
                        break;
                    }

                    String substring = input.substring(l, r + 1);

                    if (substring.equals(reverse(substring)) && substring.length() > palindrome.length()) {
                        palindrome = substring;
                        break;
                    }
                    r--;
                }

                l = input.indexOf(input.charAt(i), l + 1);

                if (l == -1) {
                    break;
                }
            }
            usedChars.add(input.charAt(i));
        }

        return palindrome;
    }

    private String reverse(String input) {
        StringBuilder output = new StringBuilder();


        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }

        return output.toString();
    }
}

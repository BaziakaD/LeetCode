package ua.baziaka.problems;

public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int val = x;
        int res = 0;

        while (val > 0) {
            res *= 10;
            res += val % 10;
            val /= 10;
        }

        return x == res;
    }
}

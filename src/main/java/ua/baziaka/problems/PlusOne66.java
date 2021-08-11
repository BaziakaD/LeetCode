package ua.baziaka.problems;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        int outputSize = digits.length + 1;
        for (int digit : digits) {
            if (digit != 9) {
                outputSize = digits.length;
                break;
            }
        }

        int[] output = new int[outputSize];
        var carry = true;

        for (int i = digits.length - 1, j = outputSize - 1; i >= 0; i--, j--) {
            int digit = digits[i];
            if (!carry) {
                output[j] = digit;
                continue;
            }
            if (digit + 1 == 10) {
                output[j] = 0;
            } else {
                output[j] = digit + 1;
                carry = false;
            }
        }

        if (carry) {
            if (digits[0] < 9) {
                output[0] = digits[0] + 1;
            } else {
                output[0] = 1;
            }
        }

        return output;
    }
}

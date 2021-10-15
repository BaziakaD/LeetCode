package ua.baziaka.problems;

public class StringToInteger8 {
    public int myAtoi(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int nine_val = Character.getNumericValue('9');
        int a_val = Character.getNumericValue('a');
        int z_val = Character.getNumericValue('z');
        char sign = ' ';

        StringBuilder result = new StringBuilder();

        char c = s.charAt(0);
        if (s.length() == 1 && (Character.getNumericValue(c) > nine_val)) {
            return 0;
        }

        char[] chars = s.toCharArray();
        for (char value : chars) {
            int numericValue = Character.getNumericValue(value);
            if (value == '-' || value == '+') {
                if (sign == ' ' && result.length() == 0) {
                    sign = value;
                } else {
                    break;
                }
            } else if ((numericValue >= a_val && numericValue <= z_val) || value == '.' || value == ' ') {
                if (value == ' ' && result.length() == 0 && sign == ' ') {
                    continue;
                }
                break;
            } else if (numericValue >= 0 && numericValue <= 9) {
                if (numericValue == 0 && result.toString().equals("0")) {
                    continue;
                }
                result.append(value);
            }
        }

        if (result.length() == 0) {
            return 0;
        }

        char[] resString = result.toString().toCharArray();
        long resultValue = 0;
        for (char val : resString) {
            int digit = Character.digit(val, 10);
            if (resultValue * 10 + digit > Integer.MAX_VALUE) {
                return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            resultValue *= 10;
            resultValue += digit;
        }

        if (sign == '-') {
            return -((int) resultValue);
        }
        return (int) resultValue;
    }

}

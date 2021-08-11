package ua.baziaka.problems;

public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.equals("1")) {
            return num2;
        }

        if (num2.equals("1")) {
            return num1;
        }

        StringBuilder result = new StringBuilder();
        String val1 = num1, val2 = num2;

        if (num1.length() < num2.length() || (num1.length() == num2.length() && num1.charAt(0) < num2.charAt(0))) {
            val1 = num2;
            val2 = num1;
        }

        char[][] intermediateResults = new char[val2.length()][];
        for (int i = val2.length() - 1, j = 0; i >= 0; i--, j++) {
            int k = Character.getNumericValue(val2.charAt(i));
            String s = compute1(val1, k);
            intermediateResults[j] = s.toCharArray();
        }

        if (intermediateResults.length == 1) {
            return String.valueOf(intermediateResults[0]);
        }
        int carry = -1;
        for (int i = 0; i < val1.length() + intermediateResults.length; i++) {
            var var = 0;
            for (int j = 0; j < intermediateResults.length; j++) {
                if (i - j >= 0) {
                    var intRes = intermediateResults[j];
                    int k = intRes.length - i - 1;
                    if (j > 0) {
                        k = intRes.length - 1 - (i - j);
                    }
                    if (k >= 0) {
                        var += Character.getNumericValue(intRes[k]);
                    }
                }
            }
            if (i == num1.length() + num2.length() - 1 && var == 0) {
                break;
            }
            if (carry != -1) {
                var += carry;
                carry = -1;
            }
            result.insert(0, var % 10);
            if (var > 9) {
                carry = var / 10;
            }
        }
        if (carry != -1) {
            result.insert(0, carry);
        }
        return result.toString();
    }

    private String compute1(String num1, int x) {
        StringBuilder result = new StringBuilder();
        var carry = -1;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int j = Character.getNumericValue(num1.charAt(i));
            int res = j * x;

            if (carry != -1) {
                res += carry;
                carry = -1;
            }
            result.insert(0, res % 10);
            if (res > 9) {
                carry = res / 10;
            }
        }
        if (carry != -1) {
            result.insert(0, carry);
        }
        return result.toString();
    }
}

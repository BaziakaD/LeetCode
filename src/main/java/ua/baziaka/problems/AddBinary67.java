package ua.baziaka.problems;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        String val1, val2;
        StringBuilder result = new StringBuilder();
        if (a.length() > b.length()) {
            val1 = a;
            val2 = b;
        } else {
            val1 = b;
            val2 = a;
        }

        boolean carry = false;

        int val1Length = val1.length();
        int val2Length = val2.length();

        for (int i = 0; i < val1Length; i++) {
            var v1 = val1.charAt(val1Length - 1 - i) == '1' ? 1 : 0;
            int v2 = 0;
            if (val2Length - 1 - i >= 0) {
                v2 = val2.charAt(val2Length - 1 - i) == '1' ? 1 : 0;
            }

            int sum = v1 + v2;
            if (sum < 2 && !carry) { // 1 + 0. 0 + 1, 0 + 0
                result.insert(0, sum);
            } else if (sum < 2) { // (1 + 0. 0 + 1, 0 + 0) + carry
                if (sum == 0) {
                    result.insert(0, "1");
                    carry = false;
                } else {
                    result.insert(0, "0");
                }
            } else if (carry) { // 1 + 1 + carry
                result.insert(0, "1");
            } else {
                result.insert(0, "0"); // 1 + 1
                carry = true;
            }
        }

        if (carry) {
            result.insert(0, "1");
        }

        return result.toString();
    }
}

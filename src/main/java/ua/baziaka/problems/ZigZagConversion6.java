package ua.baziaka.problems;

public class ZigZagConversion6 {
    public String convert(String input, int numRows) {
        StringBuilder output = new StringBuilder();

        if (numRows == 1) {
            return input;
        }

        char[] chars = input.toCharArray();

        for (int i = 0; i < numRows; i++) {
            int j = i;

            while (j < chars.length) {
                output.append(input.charAt(j));
                j += toPlus(j, numRows);
            }
        }

        return output.toString();
    }

    public String newConvert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    private int toPlus(int current, int numOfRows) {

        if (current % (numOfRows - 1) == 0) {
            current = 0;
        }

        while (current >= numOfRows) {
            current = current - numOfRows - (numOfRows - 2);
        }

        int dupl;

        if (current < 0) {
            dupl = (-1 - current) * 2;
        } else {
            dupl = (numOfRows - 1 - current - 1) * 2;
        }
        return Math.max(dupl + 2, (dupl + 2) * -1);
    }
}
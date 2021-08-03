package epam;

import java.util.HashMap;

public class MinValueInArrays {
    public static void main(String[] args) {
        // Given 3 random arrays of integers.
        // Write a method to find the smallest value that is common along in the 3 arrays.

        int[][] arrays = {
                {1},
                {1, 2},
                {1, 2, 3}
        };

        System.out.println(findSmallest(arrays));
    }

    private static int findSmallest(int[][] arrays) {

        int min = Integer.MAX_VALUE;
        var countOfOccurrencesMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                var val = arrays[i][j];
                var countOfOccurrences = countOfOccurrencesMap.getOrDefault(val, 0);
                if (countOfOccurrences < i + 1) {
                    countOfOccurrencesMap.put(val, countOfOccurrences + 1);
                    if (countOfOccurrences + 1 == arrays.length && val < min) {
                        min = val;
                    }
                }
            }
        }
        return min;
    }
}

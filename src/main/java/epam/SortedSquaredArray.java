package epam;

import java.util.Arrays;

import static java.util.Arrays.asList;

public class SortedSquaredArray {
    public static void main(String[] args) {

        /*
         * You have a sorted array of integers.
         * Write a method that returns a sorted array containing the squared of those integers.
         */
        int[][] arrays = {
                {-7, -3, 1, 4, 8, 12},
                {1, 2, 3},
                {-3, -2, -1}
        };

        for (int[] array : arrays) {
            System.out.println(Arrays.toString(sortedSquaredArray(array)));
        }
    }

    private static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0, j = array.length - 1, pointer = array.length - 1; pointer >= 0; pointer--) {
            int left = array[i] * array[i];
            int right = array[j] * array[j];

            if (right > left) {
                result[pointer] = right;
                j--;
            } else {
                result[pointer] = left;
                i++;
            }
        }

        asList().stream().toArray();
        return result;
    }
}
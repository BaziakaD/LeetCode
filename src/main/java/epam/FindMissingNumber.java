package epam;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        System.out.println(findMissing(array));
    }

    private static int findMissing(int[] array) {
        return 55 - Arrays.stream(array).sum();
    }
}

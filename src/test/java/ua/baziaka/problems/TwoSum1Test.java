package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSum1Test {

    @ParameterizedTest
    @MethodSource("testData")
    public void twoSumTest(TestData testData) {
        int[] data = testData.dataArray;

        int[] expected = testData.expectedArray;
        int target = testData.target;

        Instant before = Instant.now();
        int[] actual = new TwoSum1().twoSum(data, target);
        Instant after = Instant.now();
        System.out.println(after.getNano() - before.getNano());
        assertArrayEquals(expected, actual);
    }

    public static List<TestData> testData() {
        return Arrays.asList(
                new TestData(new int[]{2, 7, 11, 15}, new int[]{0, 1}, 9),
                new TestData(new int[]{7, 2, 11, 15}, new int[]{0, 1}, 9),
                new TestData(new int[]{7, 1, 2, 15}, new int[]{0, 2}, 9),
                new TestData(new int[]{7, 3, 11, 6}, new int[]{1, 3}, 9)
        );
    }

    @AllArgsConstructor
    private static class TestData {
        private int[] dataArray;
        private int[] expectedArray;
        private int target;
    }
}
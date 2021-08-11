package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays4 toTestAlg;

    @BeforeEach
    public void setUp() throws Exception {
        toTestAlg = new MedianOfTwoSortedArrays4();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testMedianOfTwoSortedArrays(MedianOfTwoSortedArraysTestData testData) {
        double actual = toTestAlg.findMedianSortedArrays(testData.nums1, testData.nums2);
        assertEquals(testData.output, actual);
    }

    public static List<MedianOfTwoSortedArraysTestData> testData() {
        return Arrays.asList(
                new MedianOfTwoSortedArraysTestData(new int[]{1, 3}, new int[]{2}, 2.0d),
                new MedianOfTwoSortedArraysTestData(new int[]{1, 2}, new int[]{3, 4}, 2.5d)
        );
    }

    @AllArgsConstructor
    static class MedianOfTwoSortedArraysTestData {
        int[] nums1;
        int[] nums2;
        double output;
    }

}
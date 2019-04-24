package ua.baziaka.problems;

import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays4 toTestAlg;
    MedianOfTwoSortedArraysTestData testData;

    public MedianOfTwoSortedArraysTest(MedianOfTwoSortedArraysTestData testData) {
        this.testData = testData;
    }

    @Before
    public void setUp() throws Exception {
        toTestAlg = new MedianOfTwoSortedArrays4();
    }

    @Test
    public void testMedianOfTwoSortedArrays() {
        double actual = toTestAlg.findMedianSortedArrays(testData.nums1, testData.nums2);
        Assert.assertEquals(testData.output, actual, 0.0d);
    }

    @Parameters
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
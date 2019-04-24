package ua.baziaka.problems;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];

        int length = nums3.length;
        int i = 0;
        int j =0;

        for (int k = 0; k < length; k++) {
            if (i >= nums1.length) {
                nums3[k] = nums2[j++];
            } else if (j >= nums2.length) {
                nums3[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i++];
            } else {
                nums3[k] = nums2[j++];
            }
        }

        double median;

        if (length % 2 != 0) {
            median = nums3[length / 2];
        } else {
            int m1 = nums3[length / 2];
            int m2 = nums3[length / 2 - 1];
            median = (m1 + m2) / 2d;
        }

        return median;
    }
}

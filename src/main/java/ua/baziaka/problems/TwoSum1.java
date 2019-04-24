package ua.baziaka.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int[] indicies = new int[2];

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int maybe = target - nums[i];

            if (integerMap.containsKey(maybe)) {
                indicies[0] = integerMap.get(maybe);
                indicies[1] = i;
                break;
            } else {
                integerMap.put(nums[i], i);
            }
        }
        return indicies;
    }
}
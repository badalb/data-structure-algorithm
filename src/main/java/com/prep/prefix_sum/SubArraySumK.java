package com.prep.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequency = new HashMap<>();

        // Empty prefix has sum 0
        prefixFrequency.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // How many previous prefixes produce sum k?
            int required = prefixSum - k;
            count += prefixFrequency.getOrDefault(required, 0);

            // Record the current prefix sum
            prefixFrequency.put(
                    prefixSum,
                    prefixFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println(subarraySum(nums, k)); // 2
    }

}

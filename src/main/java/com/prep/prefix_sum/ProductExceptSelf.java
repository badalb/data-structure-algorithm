package com.prep.prefix_sum;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Store products of elements to the left
        int prefix = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        // Pass 2: Multiply by products of elements to the right
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(
                Arrays.toString(productExceptSelf(nums))
        );
    }

}

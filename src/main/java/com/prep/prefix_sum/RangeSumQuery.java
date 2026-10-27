package com.prep.prefix_sum;

public class RangeSumQuery {

    public static int sumRange(int[] nums, int left, int right) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix[right + 1] - prefix[left];
    }


    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        System.out.println(sumRange(nums, 0, 2)); // 1
        System.out.println(sumRange(nums, 2, 5)); // -1
        System.out.println(sumRange(nums, 0, 5)); // -3
    }

}

package com.prep.dynamicprograming;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        int[] dp = new int[m + 2];
        for (int num : nums) {
            dp[num] += num;
        }
        for (int i = m - 1; i > 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + dp[i]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
    }
}

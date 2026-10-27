package com.prep.prefix_sum;

import java.util.Arrays;

// Range Addition — Difference Array Pattern
public class RangeAddition {

    public static int[] getModifiedArray(int n, int[][] updates) {
        int[] diff = new int[n + 1];

        // Step 1: Record the start and end of each update
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int increment = update[2];

            diff[start] += increment;
            diff[end + 1] -= increment;
        }

        // Step 2: Reconstruct the final array using prefix sums
        int[] result = new int[n];
        int runningSum = 0;

        for (int i = 0; i < n; i++) {
            runningSum += diff[i];
            result[i] = runningSum;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;

        int[][] updates = {
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };

        int[] result = getModifiedArray(n, updates);

        System.out.println(Arrays.toString(result));
    }
}

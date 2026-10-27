package com.prep.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Prefix sums: prefix[i] is the sum of nums[0..i-1]
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLength = n + 1;

        for (int j = 0; j <= n; j++) {

            // Rule 1: Remove front indices that form valid subarrays
            while (!deque.isEmpty()
                    && prefix[j] - prefix[deque.peekFirst()] >= k) {

                int left = deque.pollFirst();
                minLength = Math.min(minLength, j - left);
            }

            // Rule 2: Maintain increasing prefix sums
            while (!deque.isEmpty()
                    && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current prefix index
            deque.offerLast(j);
        }

        return minLength == n + 1 ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {84, -37, 32, 40, 95};
        int k = 167;

        System.out.println(shortestSubarray(nums, k));
        // Output: 3
    }
}
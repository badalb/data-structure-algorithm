package com.test.array;

public class MaximumSumSubarray {

	public static void main(String[] args) {
		int[] arr = { 6, 4, 3, 5, 1, 9, 7 };
		int k = 3;
		int maxSum = maxSubarraySum(arr, arr.length, k);
		System.out.println("Maximum sum sub array of size :" + k + " is:" + maxSum);
	}

	private static int maxSubarraySum(int[] arr, int n, int k) {
		if (k > n) {
			return -1;
		}
		int maxSum = 0;
		for (int i = 0; i < k; i++)
			maxSum += arr[i];

		int start = 0;
		int end = k - 1;
		int currentSum = maxSum;

		while (end < n-1) {
			currentSum -= arr[start];
			start++;
			end++;
			currentSum += arr[end];

			if (currentSum > maxSum)
				maxSum = currentSum;
		}
		return maxSum;
	}
}

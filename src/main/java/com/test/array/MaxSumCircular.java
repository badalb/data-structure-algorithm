package com.test.array;

/**
 * Max sum subarray = sum - min sum subarray
 *
 */
public class MaxSumCircular {

	public static int maxCircularSum(int a[], int n) {
		if (n == 1)
			return a[0];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		int curr_max = a[0], max_so_far = a[0], curr_min = a[0], min_so_far = a[0];

		for (int i = 1; i < n; i++) {

			// Kadane's Algorithm to find Maximum subarray
			// sum.
			curr_max = Math.max(curr_max + a[i], a[i]);
			max_so_far = Math.max(max_so_far, curr_max);

			// Kadane's Algorithm to find Minimum subarray
			// sum.
			curr_min = Math.min(curr_min + a[i], a[i]);
			min_so_far = Math.min(min_so_far, curr_min);
		}
		
		// All negative
		if (min_so_far == sum) {
			return max_so_far;
		}

		// returning the maximum value
		//Linear max sum vs circular 
		return Math.max(max_so_far, sum - min_so_far);
	}

	public static void main(String[] args) {
		// int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
		// int n = 9;
		int[] a = { 5, -3, -2, 6, -7, 4 };
		int n = a.length;
		System.out.println("Maximum circular sum is " + maxCircularSum(a, n));
	}
}
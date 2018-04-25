package com.test.dynamicprograming;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		// int[] a = { -8, -3, -6, -2, -5, -4 };
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("The sum of contiguous sub-array with the largest sum is " + kadaneAlgorithm(a));
	}

	private static int kadaneAlgorithm(int[] a) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}

		if (max < 0) {
			return max;
		}

		int maxSum = 0;
		int maxSumEndingHere = 0;

		for (int i = 0; i < a.length; i++) {
			maxSumEndingHere = maxSumEndingHere + a[i];
			maxSumEndingHere = Math.max(maxSumEndingHere, 0);

			maxSum = Math.max(maxSumEndingHere, maxSum);
		}

		return maxSum;
	}

}

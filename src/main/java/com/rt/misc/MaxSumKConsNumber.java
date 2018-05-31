package com.rt.misc;

public class MaxSumKConsNumber {

	public static void main(String[] args) {
		int[] a = { 5, 4, 1, 8, 3, 2, 7 };
		int k = 3;
		System.out.println("Maximum sum for :" + k + " consecutive No: " + calcMaxSum(a, k));
	}

	private static int calcMaxSum(int[] a, int k) {

		int i = 0;
		int j = k - 1;
		int maxSum = 0;
		int sum = 0;
		for (k = i; k <= j; k++) {
			sum += a[k];
		}
		maxSum = sum;

		while (j < a.length - 1) {
			sum = sum - a[i] + a[j + 1];
			if (sum > maxSum) {
				maxSum = sum;
			}
			i++;
			j++;
		}
		return maxSum;
	}

}

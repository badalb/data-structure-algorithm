package com.test.dynamicprograming;

public class MaxProductSubarray {

	public static void main(String[] args) {
		int[] arr = { 3, -6, -1, 0, 4 };
		System.out.println("Max product subarray:" + calculateMaxProduct(arr));
	}

	private static int calculateMaxProduct(int[] arr) {
		int maxLocal = arr[0];
		int minLocal = arr[0];
		int maxProd = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > 0) {
				maxLocal = Math.max(maxLocal * arr[i], arr[i]);
				minLocal = Math.min(minLocal * arr[i], arr[i]);
			} else {
				int maxLocalNegative = Math.max(minLocal * arr[i], arr[i]);
				minLocal = Math.min(maxLocal * arr[i], arr[i]);
				maxLocal = maxLocalNegative;
			}
			maxProd = Math.max(maxProd, maxLocal);
		}

		return maxProd;
	}
}

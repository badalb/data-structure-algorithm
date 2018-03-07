package com.test.hash;

import java.util.HashSet;

public class SubarrayZeroSum {

	private static boolean zeroSum(int[] arr) {
		HashSet<Integer> subArraySum = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (subArraySum.contains(sum)) {
				return true;
			} else {
				subArraySum.add(sum);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {1, 4, -2, -2, 5, -4, 3};
		System.out.println(zeroSum(arr));
	}

}

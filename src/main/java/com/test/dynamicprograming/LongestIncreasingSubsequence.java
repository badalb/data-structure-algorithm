package com.test.dynamicprograming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
		System.out.println(" Longest increasing subsequence length:" + getLongestIncreasingSubsequence(arr));
	}

	private static int getLongestIncreasingSubsequence(int[] arr) {
		int[] T = new int[arr.length];
		int max = 1;
		for (int i = 0; i < arr.length; i++) {
			T[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((arr[i] > arr[j]) && (T[i] < T[j] + 1)) {
					T[i] = 1 + T[j];
					if (T[i] > max) {
						max = T[i];
					}
				}
			}
		}
		return max;
	}

}

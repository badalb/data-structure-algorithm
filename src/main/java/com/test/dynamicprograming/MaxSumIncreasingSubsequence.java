package com.test.dynamicprograming;

public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 1, 3, 8, 4, 6 };
		maxSum(arr);
	}

	private static void maxSum(int arr[]) {
		int[] dpTable = new int[arr.length];
		int[] idxTable = new int[arr.length];

		for (int i = 0; i < dpTable.length; i++) {
			dpTable[i] = arr[i];
			idxTable[i] = i;
		}

		for (int i = 1; i < dpTable.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dpTable[i] = Math.max(dpTable[i], dpTable[j] + arr[i]);
					idxTable[i] = dpTable[i] > (dpTable[j] + arr[i]) ? idxTable[i] : j;
				}
			}
		}

		int maxIdx = 0;
		for (int i = 1; i < dpTable.length; i++) {
			if (dpTable[i] > dpTable[maxIdx]) {
				maxIdx = i;
			}
		}
		System.out.println("Maximum Sum: " + dpTable[maxIdx]);
		printElements(idxTable, arr, maxIdx);
	}

	private static void printElements(int[] idxTable, int arr[], int maxIdx) {
		while (true) {
			System.out.println("Elements selected: " + arr[maxIdx]);
			if (maxIdx == 0) {
				break;
			}
			maxIdx = idxTable[maxIdx];
		}
	}
}

package com.test.array;

public class MaxInCircularArray {

	public static void main(String[] args) {
		int[] arr = { 7, 0, 1, 2, 3 };
		System.out.println("Maximum number: " + findMaximumNumber(arr, 0, arr.length));
	}

	private static int findMaximumNumber(int[] arr, int low, int high) {

		if (high < low) {
			return arr[0];
		}

		if (high == low) {
			return arr[0];
		}

		int mid = low + (high - low) / 2;

		if (mid < high && arr[mid] > arr[mid + 1]) {
			return arr[mid];
		} else if (arr[mid] < arr[low]) {
			return findMaximumNumber(arr, low, mid - 1);
		} else {
			return findMaximumNumber(arr, mid + 1, high);
		}
	}

}

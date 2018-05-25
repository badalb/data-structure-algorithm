package com.rt.search;

public class FirstMissingElementArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 7, 8 };

		System.out.println("Missing element: " + search(arr, 0, arr.length));
	}

	private static int search(int[] arr, int low, int high) {

		if (low > high) {
			return high + 1;
		}

		if (low + 1 != arr[low]) {
			return low + 1;
		}

		int mid = low + (high - low) / 2;

		if (arr[mid] <= mid + 1) {
			return search(arr, mid + 1, high);
		} else {
			return search(arr, low, mid);
		}

	}
}

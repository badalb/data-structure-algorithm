package com.test.search;

public class CountOccurance {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 2, 2, 3, 4, 4 };
		int x = 4;
		int n = arr.length;
		int last = findLast(arr, 0, n, x, n);
		int first = findFirst(arr, 0, n, x, n);
		int occurance = last - first + 1;
		System.out.println(occurance);
	}

	private static int findFirst(int[] arr, int low, int high, int x, int n) {

		int mid = low + (high - low) / 2;
		while (low <= high) {
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
				return mid;
			} else if (x > arr[mid]) {
				return findFirst(arr, mid + 1, high, x, n);
			} else {
				return findFirst(arr, low, mid - 1, x, n);
			}
		}
		return -1;
	}

	private static int findLast(int[] arr, int low, int high, int x, int n) {
		int mid = low + (high - low) / 2;
		while (low <= high) {
			if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x) {
				return mid;
			} else if (x >= arr[mid]) {
				return findLast(arr, mid + 1, high, x, n);
			} else {
				return findLast(arr, low, mid - 1, x, n);
			}
		}
		return -1;
	}
}

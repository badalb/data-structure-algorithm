package com.rt.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 15, 25, 30, 40, 50 };
		int key = 40;
		int idx = binarySearch(arr, key, 0, arr.length);
		System.out.println(idx);
	}

	private static int binarySearch(int[] arr, int key, int low, int high) {

		int mid = low + (high - low) / 2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return binarySearch(arr, key, low, mid - 1);
		} else if (arr[mid] < key) {
			return binarySearch(arr, key, mid + 1, high);
		}
		return -1;
	}

}

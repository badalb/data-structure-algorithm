package com.test.sort;

public class Merge2HalvesSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 10, 15, 3, 9, 11, 20 };
		mergeSortedArrays(arr, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	private static void mergeSortedArrays(int[] arr, int k) {
		int i = 0;
		for (int j = k; j < arr.length - 1; j++) {
			for (; i < j; i++) {
				if (arr[j] <= arr[i]) {
					int temp = arr[j];
					for (int m = j; m > i; m--) {
						arr[m] = arr[m - 1];
					}
					arr[i] = temp;
					i++;
					break;
				}

			}
		}
	}

}

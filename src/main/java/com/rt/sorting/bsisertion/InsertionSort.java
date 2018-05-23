package com.rt.sorting.bsisertion;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 1, 25, 3, 11, 18 };
		insertionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void insertionSort(int[] arr) {
		int i = 0, j = 0;
		for (i = 0; i < arr.length; i++) {
			int element = arr[i];
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > element) {
					swap(j + 1, j, arr);
				}
			}
		}
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

package com.test.sort;

public class SelectionSort {

	private static void selectionSort(int[] a) {
		int minIdx = 0;
		int i = 0;
		int j = 0;
		for (i = 0; i < a.length; i++) {
			minIdx = i;
			for (j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIdx]) {
					minIdx = j;
				}
			}
			swap(i, minIdx, a);
		}

	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 10, 1, 25, 3, 11, 18 };
		selectionSort(arr);

		for (int i : arr) {
			System.out.println(i);
		}
	}

}

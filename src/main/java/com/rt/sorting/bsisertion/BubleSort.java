package com.rt.sorting.bsisertion;

public class BubleSort {

	public static void main(String[] args) {
		int[] a = { 3, 6, 1, 4, 10, 9, 5 };
		bubbleSort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private static void bubbleSort(int[] a, int n) {

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

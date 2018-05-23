package com.rt.sorting.bsisertion;

public class BubleSortRecursion {

	public static void main(String[] args) {
		int[] a = { 3, 6, 1, 4, 10, 9, 5 };
		bubbleSort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private static void bubbleSort(int[] a, int n) {

		if (n <= 1) {
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}
		bubbleSort(a, n - 1);
	}
}

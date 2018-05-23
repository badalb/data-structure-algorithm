package com.rt.sorting.bsisertion;

public class InsertionSortRecursion {

	public static void main(String[] args) {
		int[] a = { 3, 6, 1, 4, 10, 9, 5 };
		insertSort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private static void insertSort(int[] a, int n) {
		if (n <= 1) {
			return;
		}
		insertSort(a, n - 1);

		int temp = a[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			if (a[j] > temp) {
				a[j + 1] = a[j];
				a[j] = temp;
			}

		}
	}
}

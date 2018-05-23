package com.rt.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 3, 6, 1, 4, 10, 9, 5 };

		quickSort(a, 0, a.length - 1);

		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private static void quickSort(int[] a, int l, int h) {
		if (l < h) {
			int k = partition(a, l, h);
			quickSort(a, l, k - 1);
			quickSort(a, k + 1, h);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = low;
		while (low < high) {
			while (low <= high && a[low] <= a[pivot]) {
				low++;
			}
			while (low <= high && a[high] >= a[pivot]) {
				high--;
			}
			if (low < high) {
				swap(a, low, high);
			}
		}
		swap(a, pivot, high);
		return high;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

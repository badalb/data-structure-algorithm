package com.rt.sorting;

public class KthSmallest {

	public static void main(String[] args) {
		int[] a = { 3, 6, 1, 4, 10, 9, 5 };
		int k = 5;
		System.out.println(findKthSmallest(a, 0, a.length - 1, k));
	}

	private static int findKthSmallest(int[] a, int l, int h, int k) {
		int pivot = partition(a, l, h);

		if (k == pivot) {
			return a[pivot - 1];
		} else if (k < pivot) {
			return findKthSmallest(a, l, pivot - 1, k);
		} else {
			return findKthSmallest(a, pivot + 1, h, k);
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

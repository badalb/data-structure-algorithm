package com.rt.sorting.mergesort;

public class KthSmallest2SortedArray {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 8, 10 };
		int b[] = { 1, 4, 9, 15, 18 };
		int k = 4;
		System.out.println(printKthSmallest(a, b, k));
	}

	private static int printKthSmallest(int[] a, int[] b, int k) {
		int i = 0;
		int j = 0;
		int m = 0;
		while (i < a.length && j < b.length) {

			if (a[i] < b[j]) {
				i++;
				m++;
				if (m == k) {
					return a[i - 1];
				}
			} else if (a[i] > b[j]) {
				j++;
				m++;
				if (m == k) {
					return b[j - 1];
				}
			} else {
				i++;
				j++;
				m++;
				if (m == k) {
					return a[i - 1];
				}
			}

		}

		while (i < a.length) {
			i++;
			m++;
			if (m == k) {
				return a[i - 1];
			}
		}

		while (j < b.length) {
			j++;
			m++;
			if (m == k) {
				return b[j - 1];
			}
		}

		return Integer.MIN_VALUE;
	}

}

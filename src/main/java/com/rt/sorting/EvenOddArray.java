package com.rt.sorting;

public class EvenOddArray {

	public static void main(String[] args) {
		int[] a = { 3, 2, 6, 1, 4, 0, 7, 9, 8, 5 };
		shuffleElements(a);
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private static void shuffleElements(int[] a) {
		int l = 0;
		int h = a.length - 1;
		while (l < h) {
			while (l <= h && a[l] % 2 == 0) {
				l++;
			}
			while (l < h && a[h] % 2 == 1) {
				h--;
			}
			swap(a, l, h);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

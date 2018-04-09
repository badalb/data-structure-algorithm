package com.test.sort;

public class Merge2ArraysBackofOne {

	public static void main(String[] args) {

		int[] a = { 1, 5, 7, 10, 15, 0, 0, 0, 0 };
		int[] b = { 3, 9, 11, 20 };
		mergeToA(a, b);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	private static void mergeToA(int[] a, int[] b) {

		int n = a.length - 1;
		int i = a.length - b.length - 1;
		int j = b.length - 1;

		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[n] = a[i];
				i--;
				n--;
			} else {
				a[n] = b[j];
				j--;
				n--;
			}
		}

	}

}

package com.rt.misc;

public class RotateArrayKthPosition {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 3;
		// o/p: 4,5,6,7,8,1,2,3
		rotateArray(a, k);
		printarray(a);

	}

	private static void rotateArray(int[] a, int k) {
		int i = 0;
		int j = k - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}

		for (i = k, j = a.length - 1; i < j; i++, j--) {
			swap(a, i, j);
		}

		reverse(a, 0, a.length - 1);
	}

	private static void printarray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private static void reverse(int[] a, int i, int j) {
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

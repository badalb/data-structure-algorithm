package com.rt.array;

public class DiagonalElements {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println("Digonal");
		printDiagonalTopDown(a);
		System.out.println("Digonal");
		printDiagonalLeftToRight(a);
		System.out.println("Regular traversal");
		travserseArray(a);
		System.out.println("Digonal");
		printDiagonalTopRightToLeft(a);
	}

	private static void printDiagonalTopRightToLeft(int[][] a) {
		int i = 0;
		int j = a[0].length - 1;
		while (i < a.length && j >= 0) {
			System.out.println(a[i][j]);
			i++;
			j--;
		}

	}

	private static void travserseArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}
	}

	private static void printDiagonalLeftToRight(int[][] a) {
		int i = a.length - 1;
		int j = 0;
		while (i >= 0 && j <= a.length - 1) {
			System.out.print(" " + a[i][j]);
			i--;
			j++;
		}
		System.out.println();
	}

	private static void printDiagonalTopDown(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i][i]);
		}
		System.out.println();
	}

}

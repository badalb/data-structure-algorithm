package com.rt.array;

public class LeftDiagonalMatrixTraversal {

	public static void main(String[] args) {
		//int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		 int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {
		 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };
		traverse(a);
	}

	private static void traverse(int[][] a) {

		for (int k = 0; k < a.length; k++) {
			int i = k;
			int j = 0;

			while (i >= 0 && j <= a[0].length - 1) {
				System.out.print(" " + a[i][j]);
				i--;
				j++;
			}
			System.out.println();
		}

		for (int k = 1; k < a.length; k++) {
			int i = a.length - 1;
			int j = k;

			while (i >= 0 && j <= a[0].length - 1) {
				System.out.print(" " + a[i][j]);
				i--;
				j++;
			}
			System.out.println();
		}
	}

}

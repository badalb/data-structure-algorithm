package com.rt.array;

public class ZigzagMatrixTraversal {

	public static void main(String[] args) {
		//int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int a[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		zigzagTraversal(a);
	}

	private static void zigzagTraversal(int[][] a) {
		int count = a.length + a[0].length - 1;

		for (int k = 0; k < count; k++) {

			if (k % 2 == 0) {
				int i = k < a.length ? k : a.length - 1;
				int j = k < a[0].length ? 0 : k - a[0].length + 1;

				while (i >= 0 && j <= a[0].length - 1) {
					System.out.print(" " + a[i][j]);
					i--;
					j++;
				}
				System.out.println();

			} else {
				int i = k < a.length ? 0 : k - a.length + 1;
				int j = k < a[0].length ? k : a[0].length - 1;
				
				while (i <= a.length - 1 && j >= 0) {
					System.out.print(" " + a[i][j]);
					i++;
					j--;
				}
				System.out.println();

			}

		}

	}

}

package com.rt.array;

public class DiagonalHalfMatrix {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		leftBottonDiagonalHalf(a);
		topRightDiagonalHalf(a);
		leftTopDiagonalHalf(a);
		rightBottomDiagonalHalf(a);
	}

	private static void topRightDiagonalHalf(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a[0].length; j++) {
				System.out.print("    " + a[i][j]);
			}
			System.out.println();
		}
	}

	private static void leftBottonDiagonalHalf(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("    " + a[i][j]);
			}
			System.out.println();
		}

	}

	private static void leftTopDiagonalHalf(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length - i; j++) {
				System.out.print("    " + a[i][j]);
			}
			System.out.println();
		}
	}

	private static void rightBottomDiagonalHalf(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a[0].length - 1 - i; j < a[0].length; j++) {
				System.out.print("    " + a[i][j]);
			}
			System.out.println();
		}
	}

}

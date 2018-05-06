package com.rt.array;

public class SliceOfMatrix {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		printTopSlice(a);
		printLeftSlice(a);
	}

	private static void printTopSlice(int[][] a) {
		int R = a.length / 2 + 1;
		for (int i = 0; i <= R; i++) {
			for (int j = i; j < a[0].length - i; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}
	}

	private static void printLeftSlice(int[][] a) {
		int R = a.length / 2 + 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}

		for (int i = R; i < a.length; i++) {
			for (int j = 0; j < a[0].length - i; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}
	}

}

package com.rt.array;

public class SpiralArrayTraversal {

	public static void main(String[] args) {
		// int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {
		// 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		// int arr[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13,
		// 14, 15 }, { 16, 17, 18, 19, 20 },{ 21, 22, 23, 24, 25 }, { 26, 27,
		// 28, 29, 30 } };
		// int arr[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13,
		// 14, 15 } };
		// int arr[][] = { { 1, 2, 3, 4, 5 }};
		int arr[][] = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };

		spiralTraverse(arr);
	}

	private static void spiralTraverse(int[][] a) {
		int i;
		int sr = 0;
		int sc = 0;
		int er = a.length;
		int ec = a[0].length;

		while (sr < er && sc < ec) {

			for (i = sc; i < ec; i++) {
				System.out.print(a[sr][i] + " ");
			}
			sr++;
			System.out.println("");

			for (i = sr; i < er; i++) {
				System.out.print(a[i][ec - 1] + " ");
			}
			ec--;
			System.out.println("");

			if (sr < er) {
				for (i = ec - 1; i >= sc; i--) {
					System.out.print(a[er - 1][i] + " ");
				}
				er--;
			}
			System.out.println("");

			if (sc < ec) {
				for (i = er - 1; i >= sr; i--) {
					System.out.print(a[i][sc] + " ");
				}
				sc++;
			}
			System.out.println("");
		}
	}
}

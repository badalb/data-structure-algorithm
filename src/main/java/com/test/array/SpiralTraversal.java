package com.test.array;

public class SpiralTraversal {

	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print("  " + arr[i][j] + "  ");
			}
			System.out.println();
		}
	}

	private static void spiralTraverse(int[][] arr) {
		int sr = 0;
		int sc = 0;
		int er = arr.length - 1;
		int ec = arr[0].length - 1;

		while (sr < er && sc < ec) {
			for (int i = sc; i <= ec; i++) {
				System.out.print("  " + arr[sr][i]);
			}
			sr++;

			for (int j = sr; j <= er; j++) {
				System.out.print("  " + arr[j][ec]);
			}
			ec--;

			for (int k = ec; k >= sc; k--) {
				System.out.print("  " + arr[er][k]);
			}
			er--;

			for (int l = er; l >= sr; l--) {
				System.out.print("  " + arr[l][sc]);
			}
			sc++;
		}

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printArray(arr);
		System.out.println("Spiral order traversal");
		spiralTraverse(arr);
	}
}

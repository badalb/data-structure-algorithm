package com.test.array;

public class SerachInSorted2DArray {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		search(mat, 29);
	}

	private static void search(int[][] mat, int n) {
		int i = 0;
		int j = mat.length - 1;
		while (i < n && j >= 0) {
			if (mat[i][j] == n) {
				System.out.print(n + " found at " + (i + 1) + " " + (j + 1));
				return;
			}
			if (mat[i][j] > n) {
				j--;
			} else {
				i++;
			}
		}
	}
}

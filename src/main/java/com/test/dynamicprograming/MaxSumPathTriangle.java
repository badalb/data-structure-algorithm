package com.test.dynamicprograming;

public class MaxSumPathTriangle {

	public static void main(String[] args) {
		int[][] arr = { { 3 }, { 7, 4 }, { 2, 4, 6 }, { 8, 5, 9, 3 } };
		maximumPathSum(arr);
	}

	private static void maximumPathSum(int[][] arr) {
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr[i].length - 1; j >= 0; j--) {
				if (arr[i][j] + arr[i + 1][j] > arr[i][j] + arr[i + 1][j + 1]) {
					arr[i][j] = arr[i][j] + arr[i + 1][j];
				} else {
					arr[i][j] = arr[i][j] + arr[i + 1][j + 1];
				}
			}
		}
		System.out.println(arr[0][0]);
	}
}

package com.test.dynamicprograming;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		int arr[] = {5,4,6,2,7 };

		System.out.println("Minimum number of multiplications is " + findMinMultiplications(arr));

	}

	private static int findMinMultiplications(int[] arr) {
		int[][] T = new int[arr.length][arr.length];
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			T[i][i] = 0;
		}

		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length - l; i++) {
				int j = i + l;
				 T[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					temp = T[i][k] + T[k][j] + arr[i] * arr[k] * arr[j];
					if (temp < T[i][j]) {
						T[i][j] = temp;
					}
				}
			}

		}

		return T[0][arr.length-1];
	}

}

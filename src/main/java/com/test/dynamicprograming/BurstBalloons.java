package com.test.dynamicprograming;

public class BurstBalloons {

	public static void main(String args[]) {
		int input[] = { 3, 1, 5, 8 };
		System.out.print(maxCoinsBottomUpDp(input));
	}

	private static int maxCoinsBottomUpDp(int[] arr) {
		int[][] T = new int[arr.length][arr.length];

		for (int len = 1; len <= arr.length; len++) {
			for (int i = 0; i <= arr.length - len; i++) {
				int j = i + len - 1;
				for (int k = i; k <= j; k++) {
					int leftValue = 1;
					int rightValue = 1;
					if (i != 0) {
						leftValue = arr[i - 1];
					}
					if (j != arr.length - 1) {
						rightValue = arr[j + 1];
					}

					int before = 0;
					int after = 0;
					if (i != k) {
						before = T[i][k - 1];
					}
					if (j != k) {
						after = T[k + 1][j];
					}
					T[i][j] = Math.max(leftValue * arr[k] * rightValue + before + after, T[i][j]);
				}
			}
		}

		return T[0][arr.length - 1];
	}
}

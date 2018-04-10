package com.test.dynamicprograming;

public class PerfectSquares {

	private static int numSquares(int n) {
		int max = (int) Math.sqrt(n);

		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= max; j++) {
				if (i == j * j) {
					dp[i] = 1;
				} else if (i > j * j) {
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println("Min number of squares : " + numSquares(13));

	}

}

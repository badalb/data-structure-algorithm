package com.test.dynamicprograming;

public class StockSellingProblem {

	public static void main(String[] args) {
		int[] sales = { 2, 5, 7, 1, 4, 3, 1, 3 };
		int numOfTxns = 3;
		System.out.println("Maximum proffit :" + calculateMaxProfit(sales, numOfTxns));
	}

	private static int calculateMaxProfit(int[] prices, int k) {
		if (k == 0 || prices.length == 0) {
			return 0;
		}
		int T[][] = new int[k + 1][prices.length];

		for (int i = 1; i < T.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < T[0].length; j++) {
				T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
			}
		}
		return T[k][prices.length - 1];
	}
}

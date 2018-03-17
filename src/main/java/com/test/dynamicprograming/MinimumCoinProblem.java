package com.test.dynamicprograming;

public class MinimumCoinProblem {

	public static void calculateMinCoin(int sum, int[] coins) {
		if (sum <= 0) {
			System.out.println("Zero sum !!!");
		}
		int[] minCoinTable = new int[sum + 1];
		int[] selectedCoins = new int[sum + 1];

		for (int i = 0; i < minCoinTable.length; i++) {
			minCoinTable[i] = Integer.MAX_VALUE - 1;
			selectedCoins[i] = -1;
		}

		minCoinTable[0] = 0;

		for (int j = 0; j < coins.length; j++) {
			for (int i = 0; i <= sum; i++) {
				if (i >= coins[j]) {
					if (minCoinTable[i - coins[j]] + 1 < minCoinTable[i]) {
						minCoinTable[i] = 1 + minCoinTable[i - coins[j]];
						selectedCoins[i] = j;
					}
				}
			}
		}
		System.out.println("Minimum coins required for sum: " + sum + " is " + minCoinTable[sum]);
		printCoinSelection(coins, selectedCoins);
	}

	private static void printCoinSelection(int[] coins, int[] selectedCoins) {
		if (selectedCoins[selectedCoins.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = selectedCoins.length - 1;
		System.out.print("Coins used to form total ");
		while (start != 0) {
			int j = selectedCoins[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
	}

	public static void main(String[] args) {
		int[] coins = { 8, 3, 5, 1 };
		calculateMinCoin(13, coins);
	}
}

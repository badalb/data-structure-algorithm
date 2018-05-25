package com.rt.dp;

public class MinCostTrain {

	static int[][] cost = { { 0, 10, 75, 94 }, { -1, 0, 35, 50 }, { -1, -1, 0, 80 }, { -1, -1, -1, 0 } };

	public static void main(String[] args) {
		int s = 0;
		int d = 3;
		System.out.println("Min cost: " + minCost(s, d));
	}

	private static int minCost(int s, int d) {

		if (s == d || s == d - 1) {
			return cost[s][d];
		}

		int minCost = cost[s][d];

		for (int k = s + 1; k < d; k++) {
			int tempCost = minCost(s, k) + minCost(k, d);
			if (tempCost < minCost) {
				minCost = tempCost;
			}
		}
		return minCost;
	}

}

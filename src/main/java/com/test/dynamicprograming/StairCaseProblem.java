package com.test.dynamicprograming;

public class StairCaseProblem {

	private static int countWays(int n) {
		int[] T = new int[n];
		T[0] = 1;
		T[1] = 2;
		T[2] = 4;
		for (int i = 3; i < n; i++) {
			T[i] = T[i - 3] + T[i - 2] + T[i - 1];
		}
		return T[n - 1];
	}

	public static void main(String[] args) {

		int n = 10;
		System.out.println("There are :" + countWays(10) + " diff ways to reach " + n + "th floor");
	}

}

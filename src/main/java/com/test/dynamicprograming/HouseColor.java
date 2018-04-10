package com.test.dynamicprograming;

public class HouseColor {

	public static void main(String[] args) {
		int[][] costMatrix = { { 7, 5, 10 }, { 3, 6, 1 }, { 8, 7, 4 }, { 6, 2, 9 }, { 1, 4, 7 }, { 2, 3, 6 }, };
		int cost = calcHouseColoringCost(costMatrix);
		System.out.println("Cost of coloring the house is: " + cost);
	}

	private static int calcHouseColoringCost(int[][] costMatrix) {
		int[][] T = new int[costMatrix.length + 1][costMatrix[0].length];

		for (int i = 0; i < costMatrix[0].length; i++) {
			T[0][i] = 0;
		}

		for (int i = 1; i <= costMatrix.length; i++) {
			T[i][0] = costMatrix[i - 1][0] + Math.min(T[i - 1][1], T[i - 1][2]);
			T[i][1] = costMatrix[i - 1][1] + Math.min(T[i - 1][0], T[i - 1][2]);
			T[i][2] = costMatrix[i - 1][2] + Math.min(T[i - 1][0], T[i - 1][1]);
		}
		return Math.min(Math.min(T[costMatrix.length][0], T[costMatrix.length][1]), T[costMatrix.length][2]);
	}

}

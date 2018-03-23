package com.test.dynamicprograming;

public class SubsetSum {

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 7, 8, 10 };
		int sum = 11;
		checkSubsetSum(numbers, sum);
	}

	private static void checkSubsetSum(int[] numbers, int sum) {
		boolean[][] sumTable = new boolean[numbers.length+1][sum + 1];
		for (int i = 0; i <=numbers.length; i++) {
			sumTable[i][0] = true;
		}
		
		for (int i = 1; i <= numbers.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j < numbers[i-1]) {
					sumTable[i][j] = sumTable[i - 1][j];
				} else {
					sumTable[i][j] = sumTable[i - 1][j] || sumTable[i-1][j - numbers[i-1]];
				}
			}
		}

		if (sumTable[numbers.length][sum]) {
			System.out.println("There is a solution for the problem...");
			printNumbers(sumTable, numbers, sum);
		}
	}

	private static void printNumbers(boolean[][] sumTable, int[] numbers, int sum) {
		int columnIndex = sum;
		int rowIndex = numbers.length;
		while (columnIndex > 0 || rowIndex > 0) {

			if (sumTable[rowIndex][columnIndex] == sumTable[rowIndex - 1][columnIndex]) {
				rowIndex = rowIndex - 1;
			} else {
				System.out.println("We take item: " + numbers[rowIndex - 1]);
				columnIndex = columnIndex - numbers[rowIndex - 1];
				rowIndex = rowIndex - 1;
			}
		}
	}
}

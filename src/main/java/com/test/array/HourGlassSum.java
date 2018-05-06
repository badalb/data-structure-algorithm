package com.test.array;

public class HourGlassSum {

	public static void main(String[] args) {
		int[][] hourglasses = { { 1, 2, 3, 0, 0 }, { 0, 0, 0, 0, 0 }, { 2, 1, 4, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 0 } };
		System.out.println(findHourGlassSum(hourglasses));
	}

	private static int findHourGlassSum(int[][] arr) {
		int R = arr.length - 1;
		int C = arr[0].length - 1;
		int maxSum = Integer.MIN_VALUE;
		
		
		for (int i = 0; i < R - 2; i++) {
			for (int j = 0; j < C - 2; j++) {
				int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}

}

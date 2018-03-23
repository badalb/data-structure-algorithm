package com.test.array;

public class CountZero {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 1 } };
		System.out.println(countZeros(matrix));
	}

	private static int countZeros(int[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			count = count + getCount(matrix[i]);
		}
		return count;
	}

	private static int getCount(int[] arr) {
		int l = 0;
		int r = arr.length;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == 1 && arr[mid - 1] == 0) {
				return mid;
			} else if (arr[mid] == 1 && arr[mid - 1] == 1) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return 0;
	}
}

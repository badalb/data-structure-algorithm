package com.test.array;

public class Longest01Subarray {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 0, 1, 0, 1, 0, 1 };
		System.out.println(subarray(arr, arr.length));
	}

	private static int subarray(int arr[], int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
			else
				count--;
		}
		if (count == 0)
			return n;
		else {
			if (count > 0)
				return n - count;
			else
				return n + count;
		}
	}
}

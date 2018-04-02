package com.test.array;

public class ConsecutiveNumberSum {

	public static void main(String[] args) {
		findNumbers(13);
	}

	private static void findNumbers(int n) {
		int start = 1;
		int end = 1;
		int sum = 1;

		while (true) {
			if (sum == n) {
				while (start <= end) {
					System.out.println(start);
					start++;
				}
				return;
			} else if (sum < n) {
				end++;
				sum += end;
			} else {
				sum -= start;
				start++;
			}
		}
	}
}

package com.test.recursion;

public class StepsCount {

	public static void main(String[] args) {
		System.out.println(countSteps(10));
	}

	private static int countSteps(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		return countSteps(n - 3) + countSteps(n - 2) + countSteps(n - 1);
	}
}

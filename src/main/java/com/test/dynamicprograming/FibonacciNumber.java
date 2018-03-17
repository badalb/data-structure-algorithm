package com.test.dynamicprograming;

public class FibonacciNumber {

	int[] fibonacciTable;

	public FibonacciNumber(int n) {
		fibonacciTable = new int[n + 1];
	}

	public int getFibonacciNumber(int n) {

		fibonacciTable[0] = 0;
		fibonacciTable[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibonacciTable[i] = fibonacciTable[i - 1] + fibonacciTable[i - 2];
		}

		return fibonacciTable[n];
	}

	public static void main(String[] args) {
		FibonacciNumber fibonacci = new FibonacciNumber(9);
		System.out.println(fibonacci.getFibonacciNumber(9));
	}

}

package com.test.recursion;

public class Fibonaci {

	public static int fibonaci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonaci(n - 2) + fibonaci(n - 1);
	}

	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i < n; i++) {
			System.out.println(fibonaci(i));
		}
	}
}

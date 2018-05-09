package com.rt.puzzle;

public class NumberZeroFactN {

	public static void main(String[] args) {
		int n = 100;
		calculateNomZero(n);
	}

	private static void calculateNomZero(int n) {
		int count = 0;
		for (int i = 5; i <= n; i++) {

			int k = i;
			while (k % 5 == 0) {
				count++;
				k = k / 5;
			}

		}
		System.out.println("No of zeros in factorial " + n + " is :" + count);
	}

}

package com.rt.misc;

public class EvaluatePolynomial {

	public static void main(String[] args) {
		// a0xn + a1xn-1 + a2xn-2 + .... +an-1x0 + an
		int[] a = { 2, 1, 0, 3, 5 };
		int x = 2;
		int n = 4;

		System.out.println(evaluatePolynomial(a, x, n));

	}

	private static int evaluatePolynomial(int[] a, int x, int n) {
		int sum = 0;
		int pow = 1;
		int l = a.length - 1;

		while (l >= 0) {
			if (l == a.length - 1) {
				pow = 1;
			} else {
				pow = pow * x;
			}
			int val = a[l] * pow;
			sum += val;
			l--;
		}

		return sum;
	}

}

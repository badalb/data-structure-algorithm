package com.test.recursion;

public class GCD {

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	public static void main(String[] args) {
		int a = 20;
		int b = 70;
		System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
	}

}

package com.test.recursion;

public class BunnyEars {

	public static int getEars(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 2;
		}
		if (n == 2) {
			return 5;
		}

		return n / 2 * getEars(n / 2) + getEars(n % 2);
	}

	private static int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		if (bunnies % 2 == 0) {
			return 3 + bunnyEars(bunnies - 1);
		} else {
			return 2 + bunnyEars(bunnies - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(bunnyEars(5));
	}

}

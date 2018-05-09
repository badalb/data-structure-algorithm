package com.rt.puzzle;

/**
 * http://www.ritambhara.in/n-doors-puzzle/
 * https://www.geeksforgeeks.org/puzzle-16-100-doors/
 * 
 * @author badalb
 *
 */
public class ToggleDoor {

	public static void main(String[] args) {
		int doors = 100;
		calculateOpenDoors(doors);
		calcOpenDoors(doors);
	}

	private static void calcOpenDoors(int n) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (isPerfectSquare(i)) {
				count++;
			}
		}
		System.out.println("Total open doors after process completed:" + count);
	}

	private static boolean isPerfectSquare(double x) {
		double sr = Math.sqrt(x);
		return ((sr - Math.floor(sr)) == 0);
	}

	private static void calculateOpenDoors(int doors) {

		int opendoors = 0;
		for (int i = 1; i <= doors; i++) {
			int[] factors = findFactors(i);
			int n = calculateNoOfFactors(factors);
			if (isOddNoOffactors(n)) {
				//System.out.println(i);
				opendoors++;
			}
		}
		System.out.println("Total open doors after process completed:" + opendoors);
	}

	private static boolean isOddNoOffactors(int n) {
		return n % 2 == 0 ? false : true;
	}

	private static int calculateNoOfFactors(int[] factors) {
		int count = 0;
		for (int i = 0; i < factors.length; i++) {
			if (factors[i] != 0) {
				count++;
			} else if (factors[i] == 0) {
				break;
			}
		}
		return count;
	}

	private static int[] findFactors(int n) {
		int[] factors = new int[100];
		int count = -1;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				factors[++count] = i;
			}
		}
		return factors;
	}

}

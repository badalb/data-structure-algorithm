package com.test.dynamicprograming;

public class JumpGame {

	public static boolean canJump(int[] A) {
		if (A.length <= 1)
			return true;

		int max = A[0];

		for (int i = 0; i < A.length; i++) {
			if (max <= i && A[i] == 0) {
				return false;
			}
			// update max
			if (i + A[i] > max) {
				max = i + A[i];
			}

			// max is enough to reach the end
			if (max >= A.length - 1) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(" Can Jump: " + canJump(A));

		int[] B = { 3, 2, 1, 0, 4 };
		System.out.println(" Can Jump: " + canJump(B));

		int[] C = { 3, 2, 2, 0, 4 };
		System.out.println(" Can Jump: " + canJump(C));
	}

}

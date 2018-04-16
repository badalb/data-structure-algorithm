package com.test.dynamicprograming;

public class EditDistance {

	public static void main(String[] args) {
		String firstStr = "abcdef";
		String secString = "agced";

		System.out.println("Minimum change required :" + findMinChange(firstStr, secString));
	}

	private static int findMinChange(String firstStr, String secString) {
		int[][] T = new int[secString.length() + 1][firstStr.length() + 1];

		for (int i = 0; i < secString.length() + 1; i++) {
			T[i][0] = i;
		}

		for (int i = 0; i < firstStr.length() + 1; i++) {
			T[0][i] = i;
		}

		for (int i = 1; i < secString.length()+1; i++) {
			for (int j = 1; j < firstStr.length()+1; j++) {
				if (secString.charAt(i - 1) == firstStr.charAt(j - 1)) {
					T[i][j] = Math.min(T[i - 1][j - 1], Math.min(T[i - 1][j], T[i][j - 1]));
				} else {
					T[i][j] = 1 + Math.min(T[i - 1][j - 1], Math.min(T[i - 1][j], T[i][j - 1]));
				}
			}
		}

		return T[secString.length()][firstStr.length()];
	}

}

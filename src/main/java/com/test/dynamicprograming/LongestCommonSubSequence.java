package com.test.dynamicprograming;

public class LongestCommonSubSequence {
	public static void main(String[] args) {
		String s1 = "abcdaf";
		String s2 = "bcdf";
		longestCommonSubsequence(s1, s2);
	}

	private static void longestCommonSubsequence(String s1, String s2) {
		int[][] dpTable = new int[s2.length() + 1][s1.length() + 1];
		int result = 0;
		for (int i = 0; i <= s2.length(); i++) {
			for (int j = 0; j <= s1.length(); j++) {
				if (i == 0 || j == 0) {
					dpTable[i][j] = 0;
				} else if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
					dpTable[i][j] = Integer.max(dpTable[i - 1][j] + 1, dpTable[i][j-1]+1);
				} else {
					dpTable[i][j] = Integer.max(dpTable[i - 1][j], dpTable[i][j-1]);
				}
				result = Integer.max(result, dpTable[i][j]);
			}
		}
		System.out.println("Longest substring" + result);
	}

}

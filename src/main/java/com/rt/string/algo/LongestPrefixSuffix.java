package com.rt.string.algo;

public class LongestPrefixSuffix {

	public static void main(String[] args) {
		char[] str = { 'A', 'B', 'A', 'B', 'A', 'A' };
		calcLongestPrefixSuffix(str);
	}

	private static void calcLongestPrefixSuffix(char[] str) {
		int[] lps = new int[str.length];
		int i = 1;
		int j = 0;
		while (i < str.length) {
			if (str[i] == str[j]) {
				lps[i] = j + 1;
				i++;
				j++;
			} else {
				if (j == 0) {
					lps[i] = 0;
					i++;
				} else {
					j = lps[j - 1];
				}
			}

		}

		int max = Integer.MIN_VALUE;
		for (int k = 0; k < lps.length; k++) {
			if (lps[k] > max) {
				max = lps[k];
			}
		}
		System.out.println("LPS:" + max);
	}

}

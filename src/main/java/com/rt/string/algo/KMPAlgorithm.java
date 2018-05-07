package com.test.stringalgo;

public class KMPAlgorithm {

	public static void main(String[] args) {
		char[] str = "ABABDABACDABABCABAB".toCharArray();
		char[] pat = "ABABCABAB".toCharArray();
		int[] lps = calculatePLS(pat);
		kmp(str, pat, lps);
	}

	private static int[] calculatePLS(char[] str) {
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
		return lps;
	}

	private static void kmp(char[] str, char[] pat, int[] lps) {

		int i = 0;
		int j = 0;
		while (i < str.length) {
			if (str[i] == pat[j]) {
				i++;
				j++;
			}
			if (j == pat.length) {
				System.out.println("pattern found from index :" + (i - j) + " to" + i);
				j = lps[j - 1];
			}
			if (i < str.length && str[i] != pat[j]) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}
}

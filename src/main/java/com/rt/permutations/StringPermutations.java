package com.rt.permutations;

public class StringPermutations {

	public static void main(String[] args) {
		String s = "ABC";
		printPermutations(s.toCharArray(), 0, s.length());
	}

	private static void printPermutations(char[] str, int si, int n) {

		if (n <= si) {
			System.out.println(String.valueOf(str));
			return;
		}

		for (int i = si; i < n; i++) {
			swap(str, si, i);
			printPermutations(str, si + 1, n);
			swap(str, si, i);
		}

	}

	private static void swap(char[] str, int si, int i) {
		char temp = str[si];
		str[si] = str[i];
		str[i] = temp;
	}

}

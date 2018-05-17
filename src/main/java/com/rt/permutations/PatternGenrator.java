package com.rt.permutations;

public class PatternGenrator {
	public static void main(String[] args) {
		String s = "HAT";
		generatePattern(s.toCharArray(), 0, s.length());
	}

	private static void generatePattern(char[] str, int si, int n) {
		if (n <= si) {
			printString(str);
			return;
		}
		for (int i = si; i < n; i++) {
			swap(str, si, i);
			generatePattern(str, si + 1, n);
			swap(str, si, i);
			char temp = str[i];
			str[si] = '1';
			generatePattern(str, si + 1, n);
			str[si] = temp;
		}
	}

	private static void printString(char[] str) {
		String result = "";
		Integer r = 0;
		for (int k = 0; k < str.length; k++) {
			if (Character.isDigit(str[k])) {
				r = r + Integer.parseInt(String.valueOf(str[k]));
			} else {
				if (r != 0) {
					result += r.toString() + str[k];
					r = 0;
				} else {
					result += str[k];
				}

			}
		}
		if (r != 0) {
			result = result + r.toString();
		}
		System.out.println(result);
	}

	private static void swap(char[] str, int si, int i) {
		char temp = str[si];
		str[si] = str[i];
		str[i] = temp;
	}
}

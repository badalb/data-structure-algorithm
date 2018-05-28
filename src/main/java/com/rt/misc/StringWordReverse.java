package com.rt.misc;

public class StringWordReverse {

	public static void main(String[] args) {
		String s = "It is hot outside";
		System.out.println("Original String" + s);
		char[] str = s.toCharArray();
		reverseWord(str);
		System.out.println("Reverse Word: " + String.valueOf(str));
	}

	private static void reverseWord(char[] str) {
		int i = 0;
		int j = 0;

		while (j < str.length) {
			if (isWhiteSpace(str[j])) {
				int k = j;
				reverse(str, i, j - 1);
				j = k;
				j++;
				i = j;
			} else {
				j++;
			}
		}
		reverse(str, i, j - 1);
		reverse(str, 0, str.length - 1);

	}

	private static void reverse(char[] str, int i, int j) {
		while (i < j) {
			swap(str, i, j);
			i++;
			j--;
		}
	}

	private static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	private static boolean isWhiteSpace(char c) {
		return c == ' ' || c == '\n' || c == '	';
	}
}

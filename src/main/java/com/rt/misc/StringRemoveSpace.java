package com.rt.misc;

public class StringRemoveSpace {

	public static void main(String[] args) {
		// Remove space from a sentence
		String s = "It is hot outside";
		System.out.println("Original String" + s);
		String ns = removeSpace(s);
		System.out.println("Modified String" + ns);
	}

	private static String removeSpace(String s) {
		char[] str = s.toCharArray();
		int i = 0;
		int j = 0;

		while (str[i] != '\0' && !isWhiteSpace(str[i]))
			i++;

		if (str[i] == '\0') {
			return null;
		}
		j = i + 1;

		while (j != s.length()) {
			if (isWhiteSpace(str[j]))
				j++;
			else {
				str[i] = str[j];
				i++;
				j++;
			}
		}

		return String.valueOf(str).substring(0, i);
	}

	private static boolean isWhiteSpace(char c) {
		return c == ' ' || c == '\n' || c == '	';
	}

}

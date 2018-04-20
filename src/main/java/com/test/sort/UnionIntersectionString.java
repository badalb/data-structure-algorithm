package com.test.sort;

public class UnionIntersectionString {

	static int[] alphabets = new int[26];

	public static void main(String[] args) {
		String s1 = "testa";
		String s2 = "testb";

		for (char c : s1.toCharArray()) {
			alphabets[c - 'a'] = 1;
		}

		for (char c : s2.toCharArray()) {
			alphabets[c - 'a']++;
		}

		System.out.println("Union of the strings :" + findUnion());
		System.out.println("Intersection of the strings :" + findIntersection());
	}

	private static String findUnion() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] > 0) {
				char c = (char) ('a' + i);
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

	private static String findIntersection() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] >= 2) {
				char c = (char) ('a' + i);
				buffer.append(c);
			}
		}
		return buffer.toString();
	}
}

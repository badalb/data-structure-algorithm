package com.test.recursion;

public class CountPair {

	private static int countPair(String s) {
		if (s == null || "".equalsIgnoreCase(s) || s.length() < 3) {
			return 0;
		}
		if (s.charAt(0) == s.charAt(2)) {
			return 1 + countPair(s.substring(1));
		}
		return countPair(s.substring(1));
	}

	public static void main(String[] args) {
		String str = "axBx";
		System.out.println(countPair(str));
	}

}

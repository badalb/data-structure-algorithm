package com.test.recursion;

public class AllStar {

	public static String allStar(String str) {
		if (str == null || "".equalsIgnoreCase(str) || str.length() < 2) {
			return str;
		}
		return str.charAt(0) + "*" + allStar(str.substring(1));
	}

	public static void main(String[] args) {
		System.out.println(allStar("str"));

	}

}

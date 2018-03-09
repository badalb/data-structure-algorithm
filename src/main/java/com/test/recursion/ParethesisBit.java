package com.test.recursion;

public class ParethesisBit {

	public static String parenBit(String str) {
		if (!str.substring(0, 1).equals("("))
			return parenBit(str.substring(1));
		return (str.substring(0, str.indexOf(")") + 1));
	}

	public static void main(String[] args) {
		System.out.println(parenBit("xyz(abc)123"));
	}
}

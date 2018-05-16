package com.rt.googlecodejam;

public class TidyNumber {

	public static void main(String[] args) {
		String number = "538";
		System.out.println(getTidyNumber(number.toCharArray()));
	}

	private static String getTidyNumber(char[] number) {
		int n = number.length;
		for (int i = n - 2; i >= 0; i--) {
			if (number[i] > number[i + 1]) {
				number[i]--;
				for (int j = i + 1; j < n; j++) {
					number[j] = '9';
				}
			}
		}
		return String.valueOf(number);
	}

}

package com.test.dynamicprograming;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String str = "axabdba";
		getLongestPalindrome(str);
	}

	private static void getLongestPalindrome(String str) {
		boolean[][] arr = new boolean[str.length()][str.length()];
		int maxlength = 1;
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i][i] = true;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				arr[i][i + 1] = true;
				start = i;
				maxlength = 2;
			}
		}

		int n = str.length();
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				//i+1 & j-1 gives till previous character like aTa for three charater
				if (arr[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					arr[i][j] = true;
					if (k > maxlength) {
						start = i;
						maxlength = k;
					}
				}
			}
		}
		System.out.println("Longest palindrome sub string :" + str.substring(start, start + maxlength));
	}
}

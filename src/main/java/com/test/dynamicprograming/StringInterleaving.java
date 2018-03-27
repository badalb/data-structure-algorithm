package com.test.dynamicprograming;

public class StringInterleaving {

	public static void main(String[] args) {
		String x = "aabz";
		String y = "axym";
		String z = "aaxabyzm";
		isinterleaving(x, y, z);
	}

	private static void isinterleaving(String x, String y, String z) {
		boolean T[][] = new boolean[x.length() + 1][y.length() + 1];
		if (x.length() + y.length() != z.length()) {
			System.out.println("Interleaving: false");
			return;
		}

		char[] xa = x.toCharArray();
		char[] ya = y.toCharArray();
		char[] za = z.toCharArray();

		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[i].length; j++) {
				int l = i + j - 1;
				if (i == 0 && j == 0) {
					T[i][j] = true;
				} else if (i == 0) {
					if (za[l] == ya[j - 1]) {
						T[i][j] = T[i][j - 1];
					}
				} else if (j == 0) {
					if (xa[i - 1] == za[l]) {
						T[i][j] = T[i - 1][j];
					}
				} else {
					T[i][j] = (ya[i - 1] == za[l] ? T[i - 1][j] : false) || (xa[j - 1] == za[l] ? T[i][j - 1] : false);
				}
			}
		}
		System.out.println(T[x.length()][y.length()]);
	}

}

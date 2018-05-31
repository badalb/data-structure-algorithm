package com.rt.permutations;

public class PrintAllPermutationOfBalancedParenthesis {

	public static void main(String[] args) {
		int n = 3; // ()(), (())
		char[] par = new char[2 * n];
		printParenthesis(par, 0, 0, 0, n);
	}

	private static void printParenthesis(char[] par, int i, int o, int c, int n) {
		if (c == n) {
			for (int k = 0; k < par.length; k++){
				System.out.print(par[k]);
			}
			System.out.println();
			return;
		} else {

			if (o > c) {
				par[i] = ')';
				printParenthesis(par, i+1, o, c+1, n);
			}
			if (o < n) {
				par[i] = '(';
				printParenthesis(par, i+1, o+1, c, n);
			}
		}

	}

}

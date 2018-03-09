package com.test.recursion;

public class TowerOfHanoi {

	private static void towerOfHanoi(int n, char rodS, char rodD, char rodAux) {
		if (n == 1) {
			System.out.println("Move disk 1 from :" + rodS + " to " + rodD);
			return;
		}
		towerOfHanoi(n - 1, rodS, rodAux, rodD);
		System.out.println("Move disk:" + n + " from :" + rodS + " to " + rodD);
		towerOfHanoi(n - 1, rodAux, rodD, rodS);
	}

	public static void main(String[] args) {
		towerOfHanoi(4, 'A', 'B', 'C');
	}
}

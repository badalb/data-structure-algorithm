package com.rt.puzzle;

public class PiratesCoinDistribution {

	public static void main(String[] args) {
		distribute(15, 100);
	}

	private static void distribute(int pirates, int coins) {

		int[] distribution = new int[pirates];
		int remainingcoins = coins;

		if (pirates == 1) {
			distribution[0] = coins;
		}

		if (pirates == 2) {
			distribution[0] = 0;
			distribution[1] = 100;
		}

		if (pirates > 2) {
			int k = 1;
			if (pirates % 2 == 0) { // even no of pirates
				while (k <= pirates) {
					if (k == pirates) {
						distribution[k - 1] = remainingcoins;
						break;
					}
					if (k % 2 == 0) {
						distribution[k - 1] = 1;
						remainingcoins--;
					} else {
						distribution[k - 1] = 0;
					}
					k++;
				}

			} else { // odd no of pirates
				while (k <= pirates) {
					if (k == pirates) {
						distribution[k - 1] = remainingcoins;
						break;
					}
					if (k % 2 == 0) {
						distribution[k - 1] = 0;
					} else {
						distribution[k - 1] = 1;
						remainingcoins--;
					}
					k++;
				}
			}
		}
		for (int i = distribution.length - 1; i >= 0; i--) {
			System.out.println("Pirate: " + (pirates - i) + " gets :" + distribution[i] + " coins");
		}
	}

}

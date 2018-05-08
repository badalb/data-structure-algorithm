package com.rt.puzzle;

public class KingsPartyPoisionousDrum {

	public static void main(String[] args) {
		int noOfDrums = 256;
		int noOfServants = 8;
		int[] deadServant = {3};
		findPoisonousDrup(noOfDrums, noOfServants, deadServant);
	}

	private static void findPoisonousDrup(int noOfDrums, int noOfServants, int[] deadServant) {
		int[][] distribution = new int[noOfDrums][noOfServants];

		for (int i = 0; i < noOfDrums; i++) {
			// work on 0x100 to figure out
			char[] bin = Integer.toBinaryString(0x100 | i).substring(1).toCharArray();
			for (int j = 0; j < bin.length; j++) {
				distribution[i][j] = Integer.parseInt(String.valueOf(bin[j]));
			}
		}

		int[] deadservants = new int[noOfServants];
		for (int i = 0; i < deadServant.length; i++) {
			deadservants[deadServant[i] - 1] = 1;
		}

		int k = 0;
		for (; k < distribution.length; k++) {
			int j = 0;
			while (j < noOfServants) {
				if (deadservants[j] == distribution[k][j]) {
					j++;
				} else {
					break;
				}
			}

			if (j == noOfServants - 1) {
				System.out.println("Poisonous Drum: " + (k + 1));
				break;
			}
		}

	}

}

package com.test.dynamicprograming;

public class TextJustification {

	public static void main(String[] args) {
		String s = "Hello friends how are you doing today";
		int screenWidth = 10;
		String[] words = s.split(" ");
		justifyText(words, screenWidth);
	}

	private static void justifyText(String[] words, int screenWidth) {
		int[][] cost = new int[words.length][words.length];

		for (int i = 0; i < words.length; i++) {
			cost[i][i] = screenWidth - words[i].length();
			for (int j = i + 1; j < words.length; j++) {
				cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (cost[i][j] < 0) {
					cost[i][j] = Integer.MAX_VALUE;
				} else {
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
				}
			}
		}

		int minCost[] = new int[words.length];
		int result[] = new int[words.length];
		
		for (int i = words.length - 1; i >= 0; i--) {
			minCost[i] = cost[i][words.length - 1];
			result[i] = words.length;
			for (int j = words.length - 1; j > i; j--) {
				if (cost[i][j - 1] == Integer.MAX_VALUE) {
					continue;
				}
				if (minCost[i] > minCost[j] + cost[i][j - 1]) {
					minCost[i] = minCost[j] + cost[i][j - 1];
					result[i] = j;
				}
			}
		}
		int i = 0;
		int j;

		System.out.println("Minimum cost is " + minCost[0]);
		System.out.println("\n");

		StringBuilder builder = new StringBuilder();
		do {
			j = result[i];
			for (int k = i; k < j; k++) {
				builder.append(words[k] + " ");
			}
			builder.append("\n");
			i = j;
		} while (j < words.length);

		System.out.println(builder.toString());
	}
}

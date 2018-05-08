package com.rt.puzzle;

public class CamelAndBanana {

	public static void main(String[] args) {
		int totalfruits = 3000;
		int distance = 1000;
		int capacity = 1000;
		calculateRemainingFruits(totalfruits, distance, capacity);
	}

	private static void calculateRemainingFruits(int totalfruits, int distance, int capacity) {

		int remaining[] = new int[distance];
		remaining[0] = totalfruits;

		for (int i = 0; i < distance - 1; i++) {
			int timesOfcapacity = (int) Math.ceil((double) remaining[i] / capacity);
			// for x bananas with y max carrying capacity it is x/y times trips
			remaining[i + 1] = remaining[i] - (2 * timesOfcapacity - 1);
			// last trip does not require a return trip back
		}
		System.out.println("Remaining fruits: " + remaining[distance - 1]);
	}

}

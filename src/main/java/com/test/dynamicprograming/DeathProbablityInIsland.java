package com.test.dynamicprograming;

/**
 * There is an island which is represented by square matrix nxn. A person on the
 * island is standing at any given co-ordinates (x,y). He can move in any
 * direction one step right, left, up, down on the island. If he steps outside
 * the island, he dies.
 * 
 * 1. Generate NxN probability matrix P(x,y,1) for all (x, y) coordinates (x & y
 * ranges from 0 to N-1). P(x,y,1) is the probability of staying alive after
 * taking 1 step 2. Now using this, we need to calculate the NxN probability
 * matrix P(x,y,2) for all x and y - will be P(x,y,1) * { {Valid among P(x+1, y,
 * 1) + P(x, y+1, 1) + P(x-1, y, 1) + P(x, y-1, 1) } / num of valid adjascent
 * slots }. Now we have P(x,y,2) probability matrix. 3. Using induction, we can
 * calculate P(x, y, k) using P(x, y, k-1). Repeat this N times, we have our
 * probability matrix after N steps
 * 
 * @author badalb
 *
 */
public class DeathProbablityInIsland {

	public static void main(String[] args) {
		int startx = 1;
		int starty = 1;
		int size = 4;
		int steps = 3;

		System.out.println("Probablity that person will survice after " + steps + " steps ="
				+ calculateProbability(startx, starty, size, steps));
	}

	private static double calculateProbability(int x, int y, int size, int steps) {

		if (x < 0 || x >= size || y < 0 || y >= size || size <= 1) {
			return 0;
		}

		double[][] T = new double[size][size];
		double prob = 0.0;
		// k=1
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i > 0 && i < size - 1 && j > 0 && j < size - 1) {
					prob = 1.0;
				} else if ((i == 0 || i == size - 1) && (j == 0 || j == size - 1)) {
					prob = 0.5;
				} else {
					prob = 0.75;
				}
				T[i][j] = prob;
			}
		}

		for (int k = 2; k <= steps; k++) {

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					double sum_prob = 0;
					int num_prob = 0;
					if (i > 0) {
						sum_prob += T[i - 1][j];
						num_prob++;
					}
					if (i < size - 1) {
						sum_prob += T[i + 1][j];
						num_prob++;
					}
					if (j > 0) {
						sum_prob += T[i][j - 1];
						num_prob++;
					}
					if (j < size - 1) {
						sum_prob += T[i][j + 1];
						num_prob++;
					}

					T[i][j] = T[i][j] * sum_prob / num_prob;

				}
			}

		}

		return T[x][y];
	}

}

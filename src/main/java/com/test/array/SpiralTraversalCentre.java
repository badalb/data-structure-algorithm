package com.test.array;

public class SpiralTraversalCentre {

	public static void main(String[] args) {
		int[][] arr = { { 21, 22, 23, 24, 25 }, { 20, 7, 8, 9, 10 }, { 19, 6, 1, 2, 11 }, { 18, 5, 4, 3, 12 },
				{ 17, 16, 15, 14, 13 } };

		printFromCentre(arr);
	}

	private static void printFromCentre(int[][] arr) {
		int level;
		int c = arr[0].length / 2;
		int x, y;
		x = y = c;
		int cols = arr[0].length;

		for (level = 1; c + level <= cols; level++) {

			// right
			for (; y <= c + level && y < cols; y++) {
				System.out.println(arr[x][y]);
			}

			if (x == 0 && y == cols) {
				break;
			}

			// down
			for (x++, y--; x <= c + level && x < cols; x++) {
				System.out.println(arr[x][y]);
			}

			// left
			for (y--, x--; y >= c - level; y--) {
				System.out.println(arr[x][y]);
			}

			// up
			for (x--, y++; x >= c - level; x--) {
				System.out.println(arr[x][y]);
			}

			y++;
			x++;
		}

	}

}

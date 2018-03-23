package com.test.array;

import java.util.PriorityQueue;

public class PrintSorted2DArray {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 },
				{ 32, 33, 39, 50 }, };
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				queue.add(matrix[i][j]);
			}
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
}

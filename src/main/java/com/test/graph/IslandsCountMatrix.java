package com.test.graph;

public class IslandsCountMatrix {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println("Number of islands is: " + countIslands(M));
	}

	private static int countIslands(int[][] arr) {
		int count = 0;
		boolean visited[][] = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					traverse(arr, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	private static void traverse(int[][] arr, int i, int j, boolean[][] visited) {
		int rows[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int cols[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[i][j] = true;
		for (int k = 0; k < 8; ++k) {
			if (isUnvisitedOne(arr, i + rows[k], j + cols[k], visited)) {
				traverse(arr, i + rows[k], j + cols[k], visited);
			}
		}
	}

	private static boolean isUnvisitedOne(int arr[][], int row, int col, boolean visited[][]) {
		return (row >= 0) && (row < arr.length) && (col >= 0) && (col < arr[0].length)
				&& (arr[row][col] == 1 && !visited[row][col]);
	}

}

package com.test.backtracking;

public class MazeProblem {

	private int mazeSize;
	private int[][] mazeTable;
	private int[][] solutionTable;

	public MazeProblem(int mazeSize, int[][] mazeTable) {
		this.mazeSize = mazeSize;
		this.mazeTable = mazeTable;
		this.solutionTable = new int[mazeSize][mazeSize];
	}

	private void solveMaze() {
		if (traverse(0, 0)) {
			printSolution();
		} else {
			System.out.println("No Path Exists");
		}
	}

	private boolean traverse(int i, int j) {

		if (isFinish(i, j)) {
			return true;
		}
		if (isValid(i, j)) {
			solutionTable[i][j] = 1;
			if (traverse(i + 1, j)) {
				return true;
			}
			if (traverse(i, j + 1)) {
				return true;
			}
			solutionTable[i][j] = 0;
		}
		return false;
	}

	private boolean isValid(int i, int j) {
		if (i < 0 || i >= mazeSize) {
			return false;
		}
		if (j < 0 || j >= mazeSize) {
			return false;
		}

		if (mazeTable[i][j] != 1) {
			return false;
		}

		return true;
	}

	private boolean isFinish(int i, int j) {
		if (i == mazeSize - 1 && j == mazeSize - 1) {
			solutionTable[i][j] = 1;
			return true;
		}
		return false;
	}

	private void printSolution() {
		for (int i = 0; i < mazeSize; i++) {
			for (int j = 0; j < mazeSize; j++) {
				if (solutionTable[i][j] == 1) {
					System.out.print(solutionTable[i][j]);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int mazeTable[][] = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1 } };
		MazeProblem maze = new MazeProblem(5, mazeTable);
		maze.solveMaze();
	}

}

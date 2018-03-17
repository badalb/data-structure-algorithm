package com.test.backtracking;

public class KnightTour {

	private int[][] board;
	private int boardSize;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public KnightTour(int size) {
		this.boardSize = size;
		board = new int[boardSize][boardSize];
		initialize();
	}

	private void initialize() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	private void solveTour() {
		board[0][0] = 0;
		if (moves(1, 0, 0)) {
			printPath();
		} else {
			System.out.println("Not possible");
		}
	}

	private boolean moves(int steps, int x, int y) {

		if (steps == boardSize * boardSize) {
			return true;
		}
		for (int i = 0; i < boardSize; i++) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];
			
			if (isValidStep(nextX, nextY)) {
				board[nextX][nextY] = steps;
				if (moves(steps + 1, nextX, nextY)) {
					return true;
				}
				board[nextX][nextY] = Integer.MIN_VALUE;
			}
		}

		return false;
	}

	private boolean isValidStep(int x, int y) {
		if (x < 0 || x >= boardSize) {
			return false;
		}
		if (y < 0 || y >= boardSize) {
			return false;
		}
		if (board[x][y] != Integer.MIN_VALUE) {
			return false;
		}
		return true;
	}

	private void printPath() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		KnightTour tour = new KnightTour(8);
		tour.solveTour();
	}
}

package com.test.backtracking;

public class NQueenProblem {

	private int[][] board;
	private int noOfQueen;

	public NQueenProblem(int n) {
		this.noOfQueen = n;
		this.board = new int[n][n];
	}

	private void placeQueeen(int n) {
		if (setQueens(n)) {
			printBoard();
		} else {
			System.out.println("No solution possible");
		}

	}

	private boolean setQueens(int n) {
		if (n == noOfQueen) {
			return true;
		}

		for (int i = 0; i < noOfQueen; i++) {
			if (isValidPlace(i, n)) {
				board[i][n] = 1;
				if (setQueens(n + 1)) {
					return true;
				}
				//backtrack
				board[i][n] = 0;
			}
		}
		return false;
	}

	private boolean isValidPlace(int rowIndex, int colIndex) {

		if (board[rowIndex][colIndex] == 1) {
			return false;
		}
		for (int i = 0; i < noOfQueen; i++) {
			if (board[i][colIndex] == 1) {
				return false;
			}
		}

		for (int i = 0; i < noOfQueen; i++) {
			if (board[rowIndex][i] == 1) {
				return false;
			}
		}

		for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		for (int i = rowIndex, j = colIndex; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}

		return true;
	}

	private void printBoard() {
		for (int i = 0; i < noOfQueen; i++) {
			for (int j = 0; j < noOfQueen; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		NQueenProblem nQueen = new NQueenProblem(4);
		nQueen.placeQueeen(0);
	}

}

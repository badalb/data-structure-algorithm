package com.test.recursion;

public class GridPath {

	private int row;
	private int[][] grid;
	private int col;

	public GridPath(int row, int col) {
		this.row = row;
		this.col = col;
		grid = new int[row][col];
	}

	private void blockCells(int rowIdx, int colIdx) {
		grid[rowIdx][colIdx] = 1;
	}

	private boolean isValidMove(int rowIdx, int colIdx) {
		return grid[rowIdx][colIdx] == 1 ? false : true;
	}

	private void findPath(int count, int currentRow, int currentCol) {

		if (currentRow < 0 || currentCol < 0) {
			return;
		}

		if (currentRow >= row || currentCol >= col) {
			return;
		}

		if (currentRow == row - 1 && currentCol == col - 1) {
			count++;
		}

		if (!isValidMove(currentRow, currentCol)) {
			return;
		}

		findPath(count, currentRow + 1, currentCol);
		findPath(count, currentRow, currentCol + 1);
	}

	public static void main(String[] args) {
		GridPath gridPath = new GridPath(2, 3);
		gridPath.blockCells(1, 2);
		// gridPath.blockCells(2, 3);
		// gridPath.blockCells(3, 2);

		int count = 0;
		gridPath.findPath(count, 0, 0);
	}

}

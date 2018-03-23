package com.test.divideandconquer;

public class LTilesChessBoard {

	int[][] board;
	int tiles;

	LTilesChessBoard(int size) {
		this.board = new int[size][size];
		tiles = 1;
	}

	private void fillUpTiles(int topRow, int topColumn, int defectRow, int defectColumn, int size) {
		if (size == 1)
			return;
		int tileToUse = tiles++;
		int quadrantSize = size / 2;

		// tile top-left quadrant
		if (defectRow < topRow + quadrantSize && defectColumn < topColumn + quadrantSize) {
			// defect is in this quadrant
			fillUpTiles(topRow, topColumn, defectRow, defectColumn, quadrantSize);
		} else {// no defect in this quadrant
				// place a tile in bottom-right corner
			board[topRow + quadrantSize - 1][topColumn + quadrantSize - 1] = tileToUse;
			// tile the rest
			fillUpTiles(topRow, topColumn, topRow + quadrantSize - 1, topColumn + quadrantSize - 1, quadrantSize);
		}

		// tile top-right quadrant
		if (defectRow < topRow + quadrantSize && defectColumn >= topColumn + quadrantSize) {
			// defect is in this quadrant
			fillUpTiles(topRow, topColumn + quadrantSize, defectRow, defectColumn, quadrantSize);
		} else {// no defect in this quadrant
				// place a tile in bottom-left corner
			board[topRow + quadrantSize - 1][topColumn + quadrantSize] = tileToUse;
			// tile the rest
			fillUpTiles(topRow, topColumn + quadrantSize, topRow + quadrantSize - 1, topColumn + quadrantSize,
					quadrantSize);
		}

		// tile bottom-left quadrant
		if (defectRow >= topRow + quadrantSize && defectColumn < topColumn + quadrantSize) {
			// defect is in this quadrant
			fillUpTiles(topRow + quadrantSize, topColumn, defectRow, defectColumn, quadrantSize);
		} else {// place a tile in top-right corner
			board[topRow + quadrantSize][topColumn + quadrantSize - 1] = tileToUse;
			// tile the rest
			fillUpTiles(topRow + quadrantSize, topColumn, topRow + quadrantSize, topColumn + quadrantSize - 1,
					quadrantSize);
		}

		// tile bottom-right quadrant
		if (defectRow >= topRow + quadrantSize && defectColumn >= topColumn + quadrantSize) {
			// defect is in this quadrant
			fillUpTiles(topRow + quadrantSize, topColumn + quadrantSize, defectRow, defectColumn, quadrantSize);
		} else {// place tile tileToUse in top-left corner
			board[topRow + quadrantSize][topColumn + quadrantSize] = tileToUse;
			// tile the rest
			fillUpTiles(topRow + quadrantSize, topColumn + quadrantSize, topRow + quadrantSize,
					topColumn + quadrantSize, quadrantSize);
		}

	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] < 10) {
					System.out.print(" " + "0" + board[i][j] + " ");
				} else {
					System.out.print(" " + board[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int size = 8; // 2^k(3)
		LTilesChessBoard chessBoard = new LTilesChessBoard(8);
		int defectRow = 3;
		int defectCol = 2;
		int topLeftRow = 0;
		int topLetCol = 0;

		chessBoard.fillUpTiles(topLeftRow, topLetCol, defectRow, defectCol, size);
		chessBoard.printBoard();
	}
}

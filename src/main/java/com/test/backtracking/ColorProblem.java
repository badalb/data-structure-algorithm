package com.test.backtracking;

public class ColorProblem {

	private int noOfVertices;
	private int noOfColor;
	private int[][] adjacencyMatrix;
	private int[] colors;

	public ColorProblem(int noOfVertices, int noOfColor, int[][] adjacencyMatrix) {
		this.noOfVertices = noOfVertices;
		this.noOfColor = noOfColor;
		this.adjacencyMatrix = adjacencyMatrix;
		this.colors = new int[noOfVertices];
	}

	public void solveColorProblem() {
		if (solve(0)) {
			showResult();
		} else {
			System.out.println("Dont have a solution !!!");
		}
	}

	private boolean solve(int nodeIndex) {

		if (nodeIndex == noOfVertices) {
			return true;
		}

		for (int colorIndex = 1; colorIndex <= noOfColor; colorIndex++) {
			if (isColorValid(nodeIndex, colorIndex)) {
				colors[nodeIndex] = colorIndex;
				if (solve(nodeIndex + 1)) {
					return true;
				}
				colors[nodeIndex] = 0;
			}
		}
		return false;
	}

	private boolean isColorValid(int nodeIndex, int colorIndex) {

		for (int i = 0; i < noOfVertices; i++) {
			if (adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i]) {
				return false;
			}
		}
		return true;
	}

	public void showResult() {
		for (int i = 0; i < noOfVertices; i++)
			System.out.println("Node " + (i + 1) + " has color index: " + colors[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int[][] adjacencyMatrix = new int[][] { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 } };
		int numOfColors = 3;

		ColorProblem colorProblem = new ColorProblem(4, numOfColors, adjacencyMatrix);
		colorProblem.solveColorProblem();
	}

}

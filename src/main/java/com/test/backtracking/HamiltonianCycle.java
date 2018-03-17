package com.test.backtracking;

public class HamiltonianCycle {

	private int noOfVertices;
	private int[][] adjacencyMatrix;
	private int[] hamiltonianPath;

	public HamiltonianCycle(int[][] adjacencyMatrix, int noOfVertices) {
		this.adjacencyMatrix = adjacencyMatrix;
		this.noOfVertices = noOfVertices;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
	}

	private void solveHamiltonianCycle() {
		// add first in the path
		hamiltonianPath[0] = 0;
		if (findFeasibleSolution(1)) {
			printHamiltonianPath();
		} else {
			System.out.println("No path found");
		}
	}

	private void printHamiltonianPath() {
		System.out.println("Below is the hamiltonian Path : ");
		for (int i = 0; i < hamiltonianPath.length; i++) {
			System.out.println(hamiltonianPath[i]);
		}
	}

	private boolean findFeasibleSolution(int position) {
		// we have added all the vertices new check for a path from last to
		// starting vertex
		if (position == noOfVertices) {
			if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		// add vertex one by one to the path
		for (int vertexIndex = 1; vertexIndex < noOfVertices; vertexIndex++) {
			if (isFeasible(vertexIndex, position)) {
				hamiltonianPath[position] = vertexIndex;
				if (findFeasibleSolution(position + 1)) {
					return true;
				}
				hamiltonianPath[position] = 0;
			}
		}
		return false;
	}

	private boolean isFeasible(int vertexIndex, int actualPosition) {
		// no path from previous vertex to current vertex
		if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
			return false;
		}
		// Not already added in the path
		for (int j = 0; j < actualPosition; j++) {
			if (hamiltonianPath[j] == vertexIndex) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int adjacencyMatrix[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };
		HamiltonianCycle hamiltonian = new HamiltonianCycle(adjacencyMatrix, 5);
		hamiltonian.solveHamiltonianCycle();
	}
}

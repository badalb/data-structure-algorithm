package com.test.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrixGraph implements Graph {

	private GraphType graphType;

	private int size;

	private int[][] graph;

	public AdjacencyMatrixGraph(int size, GraphType graphType) {
		this.graphType = graphType;
		this.size = size;
		graph = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				graph[i][j] = 0;
			}
		}
	}

	@Override
	public void addEdge(int v1, int v2) {

		if (v1 - 1 >= size || v1 - 1 < 0 || v2 - 1 >= size || v2 - 1 < 0) {
			System.out.println("Invalid input");
		}

		graph[v1 - 1][v2 - 1] = 1;
		if (graphType == GraphType.UNDIRECTED) {
			graph[v2 - 1][v1 - 1] = 1;
		}

	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v - 1 >= size || v - 1 < 0) {
			System.out.println("Invalid input");
			return null;
		}

		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (graph[v - 1][i] == 1) {
				vertices.add(i + 1);
			}
		}
		Collections.sort(vertices);
		return vertices;
	}

	public void printGraph() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public void bfs(int v) {
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<>();

		System.out.println("Visiting vertex :" + v);
		visited[v - 1] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			if (!visited[vertex - 1]) {
				System.out.println("Visiting vertex :" + (vertex));
				visited[vertex - 1] = true;
			}
			List<Integer> adjacentVertices = getAdjacentVertices(vertex);
			for (int adv : adjacentVertices) {
				if (!visited[adv - 1]) {
					queue.add(adv);
				}
			}
		}
	}
	
	public void dfs(int v){
		boolean[] visited = new boolean[size];
		Stack<Integer> stack = new Stack<>();

		System.out.println("Visiting vertex :" + v);
		visited[v - 1] = true;
		stack.add(v);
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (!visited[vertex - 1]) {
				System.out.println("Visiting vertex :" + (vertex));
				visited[vertex - 1] = true;
			}
			List<Integer> adjacentVertices = getAdjacentVertices(vertex);
			for (int adv : adjacentVertices) {
				if (!visited[adv - 1]) {
					stack.add(adv);
				}
			}
		}
	}

}

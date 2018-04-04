package com.test.graph.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.test.graph.GraphType;

public class UnreachableVerticesGraph {

	private GraphType graphType;

	private int size;

	private int[][] graph;

	public UnreachableVerticesGraph(int size, GraphType graphType) {
		this.graphType = graphType;
		this.size = size;
		graph = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				graph[i][j] = 0;
			}
		}
	}

	public void addEdge(int v1, int v2) {

		if (v1 >= size || v1 < 0 || v2 - 1 >= size || v2 < 0) {
			System.out.println("Invalid input");
		}

		graph[v1][v2] = 1;
		if (graphType == GraphType.UNDIRECTED) {
			graph[v2][v1] = 1;
		}

	}

	public List<Integer> getAdjacentVertices(int v) {
		if (v >= size || v < 0) {
			System.out.println("Invalid input");
			return null;
		}

		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (graph[v][i] == 1) {
				vertices.add(i);
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

	public void unreachableNodes(int v) {
		boolean[] visited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<>();

		// System.out.println("Visiting vertex :" + v);
		visited[v] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			if (!visited[vertex]) {
				// System.out.println("Visiting vertex :" + (vertex));
				visited[vertex] = true;
			}
			for (int vtx : getAdjacentVertices(vertex)) {
				if (!visited[vtx]) {
					queue.add(vtx);
				}
			}
		}

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				System.out.println("Node :" + i + " is an unreachbale node");
			}
		}
	}

	public static void main(String[] args) {
		UnreachableVerticesGraph graph = new UnreachableVerticesGraph(6, GraphType.UNDIRECTED);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.printGraph();

		graph.unreachableNodes(0);
	}

}

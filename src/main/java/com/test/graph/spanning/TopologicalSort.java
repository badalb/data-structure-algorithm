package com.test.graph.spanning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.test.graph.GraphType;

public class TopologicalSort {

	private GraphType graphType;

	private int noOfVertices;

	private int[][] graph;

	public TopologicalSort(int size, GraphType graphType) {
		this.graphType = graphType;
		this.noOfVertices = size;
		graph = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				graph[i][j] = 0;
			}
		}
	}

	public void addEdge(int v1, int v2) {
		if (v1 >= noOfVertices || v1 < 0 || v2 >= noOfVertices || v2 < 0) {
			System.out.println("Invalid input");
		}
		graph[v1][v2] = 1;
		if (graphType == GraphType.UNDIRECTED) {
			graph[v2][v1] = 1;
		}
	}

	public List<Integer> getAdjacentVertices(int v) {
		if (v >= noOfVertices || v < 0) {
			System.out.println("Invalid input");
			return null;
		}

		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < noOfVertices; i++) {
			if (graph[v][i] == 1) {
				vertices.add(i);
			}
		}
		Collections.sort(vertices);
		return vertices;
	}

	private int getIndegree(int vertex) {
		int inDegree = 0;
		for (int i = 0; i < noOfVertices; i++) {
			if (graph[i][vertex] == 1) {
				inDegree++;
			}
		}
		return inDegree;
	}

	public void printGraph() {
		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfVertices; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public static void main(String[] args) {
		TopologicalSort graph = new TopologicalSort(8, GraphType.DIRECTED);
		graph.addEdge(2, 7);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 7);

		printList(sort(graph));
	}

	public static void printList(List<Integer> list) {
		for (int v : list) {
			System.out.println(v + ", ");
		}
	}

	private static List<Integer> sort(TopologicalSort graph) {
		LinkedList<Integer> queue = new LinkedList<>();
		Map<Integer, Integer> indegreeMap = new HashMap<>();

		for (int vertex = 0; vertex < graph.getNoOfVertices(); vertex++) {
			int indegree = graph.getIndegree(vertex);
			indegreeMap.put(vertex, indegree);
			if (indegree == 0) {
				queue.add(vertex);
			}
		}
		List<Integer> sortedList = new ArrayList<>();

		while (!queue.isEmpty()) {
			int vertex = queue.pollFirst();
			sortedList.add(vertex);

			List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
			for (int adjacentVertex : adjacentVertices) {
				int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
				indegreeMap.remove(adjacentVertex);
				indegreeMap.put(adjacentVertex, updatedIndegree);

				if (updatedIndegree == 0) {
					queue.add(adjacentVertex);
				}
			}
		}

		if (sortedList.size() != graph.getNoOfVertices()) {
			throw new RuntimeException("The Graph had a cycle!");
		}
		return sortedList;
	}
}

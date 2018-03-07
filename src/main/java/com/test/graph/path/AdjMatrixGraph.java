package com.test.graph.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.test.graph.GraphType;

public class AdjMatrixGraph implements com.test.graph.Graph {

	private GraphType graphType;

	private int size;

	private int[][] graph;

	public AdjMatrixGraph(int size, GraphType graphType) {
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

		if (v1 >= size || v1 < 0 || v2 >= size || v2 < 0) {
			System.out.println("Invalid input");
		}

		graph[v1][v2] = 1;
		if (graphType == GraphType.UNDIRECTED) {
			graph[v2][v1] = 1;
		}
	}

	@Override
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
	
	public int getSize() {
		return size;
	}



	public static class DistanceInfo {

		private int distance;
		private int lastVertex;

		public DistanceInfo() {
			distance = -1;
			lastVertex = -1;
		}

		public DistanceInfo(int distance, int lastVertex) {
			super();
			this.distance = distance;
			this.lastVertex = lastVertex;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int getLastVertex() {
			return lastVertex;
		}

		public void setLastVertex(int lastVertex) {
			this.lastVertex = lastVertex;
		}
	}

	public static void main(String[] args) {
		AdjMatrixGraph graph = new AdjMatrixGraph(8, GraphType.DIRECTED);
		graph.addEdge(2, 7);
		graph.addEdge(3, 0);
		graph.addEdge(0, 4);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(6, 3);
		graph.addEdge(4, 7);

		shortestPath(graph, 0, 3);
	}

	private static void shortestPath(AdjMatrixGraph graph, int source, int destination) {
		Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
		Stack<Integer> stack = new Stack<>();
		stack.push(destination);

		int previousVertex = distanceTable.get(destination).getLastVertex();
		while (previousVertex != -1 && previousVertex != source) {
			stack.push(previousVertex);
			previousVertex = distanceTable.get(previousVertex).getLastVertex();
		}

		if (previousVertex == -1) {
			System.out.println("There is no path from node: " + source + " to node: " + destination);
		} else {
			System.out.print("Smallest path is " + source);
			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println(" Shortest Path Unweighted DONE!");
		}
	}

	private static Map<Integer, DistanceInfo> buildDistanceTable(AdjMatrixGraph graph, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
		for (int j = 0; j < graph.size; j++) {
			distanceTable.put(j, new DistanceInfo());
		}
		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty()) {
			int currentVertex = queue.pollFirst();
			for (int i : graph.getAdjacentVertices(currentVertex)) {
				int currentDistance = distanceTable.get(i).getDistance();
				if (currentDistance == -1) {
					currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
					distanceTable.get(i).setDistance(currentDistance);
					distanceTable.get(i).setLastVertex(currentVertex);
					if (!graph.getAdjacentVertices(i).isEmpty()) {
						queue.add(i);
					}
				}
			}
		}
		return distanceTable;
	}
}

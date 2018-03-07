package com.test.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DirectedWeightedGraph {

	private List<Node> vertices = new ArrayList<>();

	public DirectedWeightedGraph() {

	}

	public void addVertices(Node vertex) {
		vertices.add(vertex);
	}

	public void addEdge(String v1, String v2, int weight) {

		for (Node vertex : vertices) {
			if (vertex.getLabel().equalsIgnoreCase(v1)) {
				vertex.getEdges().add(new Edge(weight, v2));
			}
		}

	}

	public List<Edge> getAdjacentVertices(String v) {
		for (Node vertex : vertices) {
			if (vertex.getLabel().equalsIgnoreCase(v)) {
				List<Edge> edges = vertex.getEdges();
				return edges;
			}
		}
		return null;
	}

	public void bfs(String v) {
		List<String> visited = new ArrayList<String>();
		Queue<String> visitQueue = new java.util.LinkedList<>();
		System.out.println("Visiting Node: " + v);
		visited.add(v);
		visitQueue.add(v);
		while (!visitQueue.isEmpty()) {
			String vertex = visitQueue.poll();
			if (!visited.contains(vertex)) {
				System.out.println("Visiting Node :" + vertex);
				visited.add(vertex);
			}
			for (Edge e : getAdjacentVertices(vertex)) {
				if (!visited.contains(e.getDestination())) {
					visitQueue.add(e.getDestination());
				}
			}
		}

	}
}

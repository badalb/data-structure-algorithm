package com.test.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyListGraph implements Graph {

	private GraphType graphType;
	private int noOfVertices;
	private List<GraphNode> nodes = new ArrayList<>();

	public AdjacencyListGraph(GraphType graphType, int noOfVertices) {
		this.graphType = graphType;
		this.noOfVertices = noOfVertices;

		for (int i = 0; i < noOfVertices; i++) {
			nodes.add(new GraphNode(i));
		}
	}

	@Override
	public void addEdge(int v1, int v2) {
		if (v1 >= noOfVertices || v1 < 0 || v2 >= noOfVertices || v2 < 0) {
			System.out.println("Invalid edge");
			return;
		}

		GraphNode node = nodes.get(v1);
		node.addEdge(v2);
		if (graphType == GraphType.UNDIRECTED) {
			nodes.get(v2).addEdge(v1);
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v >= noOfVertices || v < 0) {
			System.out.println("Invalid Vertex");
			return null;
		}
		GraphNode node = nodes.get(v);
		List<Integer> edges = node.getAdjacencyList();
		Collections.sort(edges);
		return edges;
	}

}

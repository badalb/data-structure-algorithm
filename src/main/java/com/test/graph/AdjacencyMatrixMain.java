package com.test.graph;

public class AdjacencyMatrixMain {

	public static void main(String[] args) {
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, GraphType.UNDIRECTED);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(2, 5);
		graph.printGraph();

		graph.bfs(1);
		graph.dfs(1);
	}

}

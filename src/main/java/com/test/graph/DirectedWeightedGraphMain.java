package com.test.graph;

import java.util.List;

public class DirectedWeightedGraphMain {

	public static void main(String[] args) {

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");

		DirectedWeightedGraph dag = new DirectedWeightedGraph();
		dag.addVertices(a);
		dag.addVertices(b);
		dag.addVertices(c);
		dag.addVertices(d);
		dag.addVertices(e);

		dag.addEdge("A", "B", 1);
		dag.addEdge("A", "C", 3);
		dag.addEdge("B", "D", 2);
		dag.addEdge("C", "D", 4);
		dag.addEdge("B", "E", 3);

		List<Edge> edges = dag.getAdjacentVertices("A");
		edges.forEach(edge -> {
			System.out.println(edge.getDestination() + "->" + edge.getWeight());
		});

		dag.bfs("A");
	}

}

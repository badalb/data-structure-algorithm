package com.test.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String label;
	private List<Edge> edges = new ArrayList<>();

	public Node() {

	}

	public Node(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}

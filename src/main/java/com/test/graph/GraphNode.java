package com.test.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	private int data;
	private List<Integer> adjacencyList = new ArrayList<>();

	public GraphNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<Integer> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<Integer> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public void addEdge(int data) {
		adjacencyList.add(data);
	}
}

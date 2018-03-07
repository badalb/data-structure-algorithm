package com.test.graph;

import java.util.List;

public interface Graph {

	public void addEdge(int v1, int v2);

	public List<Integer> getAdjacentVertices(int v);

}

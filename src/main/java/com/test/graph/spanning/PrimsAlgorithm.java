package com.test.graph.spanning;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.test.graph.path.AdjMatrix;
import com.test.graph.path.DistanceInfo;
import com.test.graph.path.Graph;
import com.test.graph.path.VertexInfo;

public class PrimsAlgorithm {

	public static void main(String[] args) {
		Graph graph = new AdjMatrix(8, Graph.GraphType.DIRECTED);
		graph.addEdge(2, 7, 4);
		graph.addEdge(0, 3, 2);
		graph.addEdge(0, 4, 2);
		graph.addEdge(0, 1, 1);
		graph.addEdge(2, 1, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(3, 5, 1);
		graph.addEdge(3, 6, 3);
		graph.addEdge(4, 7, 2);
		graph.addEdge(7, 5, 4);
		spanningTree(0, graph);
	}

	private static void spanningTree(int source, Graph graph) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
		PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
			@Override
			public int compare(VertexInfo v1, VertexInfo v2) {
				return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
			}
		});

		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceInfo());
		}

		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

		VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
		queue.add(sourceVertexInfo);
		vertexInfoMap.put(source, sourceVertexInfo);

		Set<String> spanningTree = new HashSet<>();
		Set<Integer> visitedVertices = new HashSet<>();

		while (!queue.isEmpty()) {

			VertexInfo vertextInfo = queue.poll();
			int currentVertex = vertextInfo.getVertexId();
			if (visitedVertices.contains(currentVertex)) {
				continue;
			}
			visitedVertices.add(currentVertex);
			if (currentVertex != source) {
				String edge = String.valueOf(distanceTable.get(currentVertex).getLastVertex())
						+ String.valueOf(currentVertex);
				if (!spanningTree.contains(edge)) {
					spanningTree.add(edge);
				}
			}

			for (int neighbour : graph.getAdjacentVertices(currentVertex)) {
				int distance = graph.getWeightedEdge(currentVertex, neighbour);
				if (distanceTable.get(neighbour).getDistance() > distance) {
					distanceTable.get(neighbour).setDistance(distance);
					distanceTable.get(neighbour).setLastVertex(currentVertex);

					VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
					if (neighbourVertexInfo != null) {
						queue.remove(neighbourVertexInfo);
					}

					neighbourVertexInfo = new VertexInfo(neighbour, distance);
					vertexInfoMap.put(neighbour, neighbourVertexInfo);
					queue.add(neighbourVertexInfo);
				}
			}

		}

		for (String edge : spanningTree) {
			System.out.println(edge);
		}
	}

}

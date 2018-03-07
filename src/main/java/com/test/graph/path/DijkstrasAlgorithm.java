package com.test.graph.path;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstrasAlgorithm {

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

		shortestPath(graph, 0, 5);
	}

	private static void shortestPath(Graph graph, int source, int destination) {
	
		 Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

	        Stack<Integer> stack = new Stack<>();
	        stack.push(destination);

	        int previousVertex = distanceTable.get(destination).getLastVertex();
	        while (previousVertex != -1 && previousVertex != source) {
	            stack.push(previousVertex);
	            previousVertex = distanceTable.get(previousVertex).getLastVertex();
	        }

	        if (previousVertex == -1) {
	            System.out.println("There is no path from node: " + source
	                    + " to node: " + destination);
	        }
	        else {
	            System.out.print("Smallest Path is " + source);
	            while (!stack.isEmpty()) {
	                System.out.print(" -> " +stack.pop());
	            }
	            System.out.println(" Dijkstra  DONE!");
	        }
	    }

	private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });
        
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);
        
        while (!queue.isEmpty()) {
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
                // Get the new distance, account for the weighted edge.
                int distance = distanceTable.get(currentVertex).getDistance()
                        + graph.getWeightedEdge(currentVertex, neighbour);

                // If we find a new shortest path to the neighbour update
                // the distance and the last vertex.
                if (distanceTable.get(neighbour).getDistance() > distance) {
                    distanceTable.get(neighbour).setDistance(distance);
                    distanceTable.get(neighbour).setLastVertex(currentVertex);

                    // We've found a new short path to the neighbour so remove
                    // the old node from the priority queue.
                    VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);
                    if (neighbourVertexInfo != null) {
                        queue.remove(neighbourVertexInfo);
                    }

                    // Add the neighbour back with a new updated distance.
                    neighbourVertexInfo = new VertexInfo(neighbour, distance);
                    queue.add(neighbourVertexInfo);
                    vertexInfoMap.put(neighbour, neighbourVertexInfo);
                }
            }
        }
        return distanceTable;
	}
}

package com.test.graph;

public class Edge {
	
	private int weight;
	private String destination;
	
	public Edge(){
		
	}
	
	public Edge(int weight, String destination) {
		super();
		this.weight = weight;
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}

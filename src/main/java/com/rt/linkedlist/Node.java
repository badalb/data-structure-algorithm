package com.rt.linkedlist;

public class Node {

	private Node next;
	private int data;

	public Node() {
	}

	public Node(Node next, int data) {
		super();
		this.next = next;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}

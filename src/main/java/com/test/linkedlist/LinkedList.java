package com.test.linkedlist;

public class LinkedList {

	private Node head;

	public LinkedList(Node node) {
		this.head = node;
	}

	public LinkedList() {
	}

	public Node removeNodeWithKey(int value) {

		// empty list
		if (head == null) {
			System.out.println("List is Empty .... ");
			return null;
		}

		Node current = head;
		while (current != null && current.getNext() != null) {
			if (current.getNext().getData() == value) {
				current.setNext(current.getNext().getNext());
			} else {
				current = current.getNext();
			}
		}

		// single node
		if (head != null) {
			if (head.getData() == value) {
				head = head.getNext();
			}
		}
		return head;
	}

	public Node insertEnd(Node node) {
		Node temp = head;
		if (temp == null) {
			head = node;
			return head;
		}

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(node);

		return head;
	}

	public void printList(Node start) {
		while (start != null) {
			System.out.print(start.getData());
			System.out.print("->");
			start = start.getNext();
		}
		System.out.print("null");
	}

	// Let's expose the head
	public Node getHead() {
		return head;
	}
}

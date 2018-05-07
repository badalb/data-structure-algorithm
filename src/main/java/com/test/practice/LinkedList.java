package com.test.practice;

import com.test.linkedlist.Node;

public class LinkedList {

	private Node head;

	public LinkedList(Node node) {
		this.head = node;
	}

	public LinkedList() {
	}

	public Node getHead() {
		return head;
	}

	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void reverse(Node current, Node prev) {
		if (current.getNext() == null) {
			head = current;
			current.setNext(prev);
			return;
		}

		Node next = current.getNext();
		current.setNext(prev);
		prev = current;
		reverse(next, prev);
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
}

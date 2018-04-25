package com.test.linkedlist;

public class ReverseLinkedList {

	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);

		head.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(null);
		head = reverseIterative(head);
		display(head);
		head = reverse(head);
		display(head);
	}

	private static Node reverse(Node n) {
		Node nhead;
		if (n.getNext() == null) {
			return n;
		}
		nhead = reverse(n.getNext());
		n.getNext().setNext(n);
		n.setNext(null);
		
		return nhead;
	}

	public static Node reverseIterative(Node head) {
		Node currNode = head;
		Node nextNode = null;
		Node prevNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		return head;
	}

	public static void display(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

}

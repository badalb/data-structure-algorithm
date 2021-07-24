package com.rt.linkedlist;

public class RemoveDuplicateLinkedList {

	static class Node {

		private int data;

		private Node next;

		public Node(int data) {
			super();
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

	public static void removeDuplicate(Node head) {

		if (head == null || head.next == null) {
			return;
		}

		while (head != null) {
			if (head.next != null) {
				while (head.next != null && head.data == head.next.data) {
					Node temp = head.next;
					head.next = temp.next;
				}
			}

			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node three = new Node(1);
		head.setNext(three);
		Node seven = new Node(7);
		three.setNext(seven);
		Node nine = new Node(9);
		seven.setNext(nine);
		Node nine2 = new Node(9);
		nine.setNext(nine2);

//		while (head != null) {
//			System.out.println(head.data);
//			head = head.next;
//		}

		removeDuplicate(head);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

}

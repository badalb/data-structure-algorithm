package com.rt.linkedlist;

public class Sort012LinkedList {
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

	private static Node sortList(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node zeroH = null;
		Node zeroEnd = null;
		Node oneH = null;
		Node oneEnd = null;
		Node twoH = null;

		while (head != null) {
			Node temp = head;
			head = head.next;
			temp.next = null;
			
			if (temp.data == 0) {
				temp.next = zeroH;
				zeroH = temp;
				if (zeroEnd == null) {
					zeroEnd = zeroH;
				}
			}
			if (temp.data == 1) {
				temp.next = oneH;
				oneH = temp;
				if (oneEnd == null) {
					oneEnd = oneH;
				}
			}

			if (temp.data == 2) {
				temp.next = twoH;
				twoH = temp;
			}

		}

		// Assuming that list actually has 0s,1s and 2s. Else some conditin
		// checks

		zeroEnd.next = oneH;
		oneEnd.next = twoH;

		return zeroH;
	}

	public static void display(Node head) {
		Node currNode = head;
		System.out.print("start");
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(0);
		Node four = new Node(0);
		Node five = new Node(1);
		Node six = new Node(2);

		head.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);
		display(head);
		Node nHead = sortList(head);
		System.out.println("");
	   display(nHead);

	}

}

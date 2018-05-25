package com.rt.linkedlist;

public class MaximumSumList {

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

	private static Node finalMaxSumList(Node a, Node b) {
		Node result = null;

		Node pre1 = a, curr1 = a;
		Node pre2 = b, curr2 = b;

		while (curr1 != null || curr2 != null) {

			int sum1 = 0, sum2 = 0;
			while (curr1 != null && curr2 != null && curr1.data != curr2.data) {

				if (curr1.data < curr2.data) {
					sum1 += curr1.data;
					curr1 = curr1.next;
				} else {
					sum2 += curr2.data;
					curr2 = curr2.next;
				}
			}

			if (curr1 == null) {
				while (curr2 != null) {
					sum2 += curr2.data;
					curr2 = curr2.next;
				}
			}
			if (curr2 == null) {
				while (curr1 != null) {
					sum1 += curr1.data;
					curr1 = curr1.next;
				}
			}

			if (pre1 == a && pre2 == b) {
				result = (sum1 > sum2) ? pre1 : pre2;
			} else {
				if (sum1 > sum2) {
					pre2.next = pre1.next;
				} else {
					pre1.next = pre2.next;
				}
			}

			pre1 = curr1;
			pre2 = curr2;

			if (curr1 != null) {
				curr1 = curr1.next;
			}

			if (curr2 != null) {
				curr2 = curr2.next;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Node head1 = createFirstList();
		Node head2 = createSecondList();
		Node head = finalMaxSumList(head1, head2);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	private static Node createFirstList() {
		Node head = new Node(1);
		Node three = new Node(3);
		head.setNext(three);

		Node seven = new Node(7);
		three.setNext(seven);
		Node nine = new Node(9);
		seven.setNext(nine);
		return head;
	}

	private static Node createSecondList() {
		Node head = new Node(0);
		Node thre = new Node(3);
		head.setNext(thre);

		Node five = new Node(5);
		thre.setNext(five);
		Node sven = new Node(7);
		five.setNext(sven);

		Node eight = new Node(8);
		sven.setNext(eight);
		return head;
	}

}

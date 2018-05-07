package com.rt.linkedlist;

public class RevereseStepwiseLinkedList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.setNext(two);
		ListNode three = new ListNode(3);
		two.setNext(three);
		ListNode four = new ListNode(4);
		three.setNext(four);
		ListNode five = new ListNode(5);
		four.setNext(five);
		ListNode six = new ListNode(6);
		five.setNext(six);
		ListNode seven = new ListNode(7);
		six.setNext(seven);
		ListNode eight = new ListNode(8);

		seven.setNext(eight);
		printList(head);
		head = reverseList(head, 3);
		printList(head);
	}

	private static ListNode reverseList(ListNode head, int step) {

		ListNode newhead = null;
		ListNode revhead = null;
		ListNode stephead = head;
		ListNode current = head;
		ListNode prev = null;

		for (int i = 1; current != null && i <= step; i++) {
			prev = current;
			current = current.getNext();
			if (i % step == 0 || current == null) {
				head = current;
				prev.setNext(null);
				revhead = reverseList(stephead);
				if (newhead == null) {
					newhead = revhead;
				} else {
					ListNode temp = newhead;
					while (temp.getNext() != null) {
						temp = temp.getNext();
					}
					temp.setNext(revhead);
				}
				stephead = head;
				i = 0;
			}
		}
		return newhead;
	}

	private static ListNode reverseList(ListNode stephead) {
		ListNode a = null;
		ListNode b = stephead;
		ListNode c = stephead.getNext();
		while (b != null) {
			b.setNext(a);
			a = b;
			b = c;
			if (c != null) {
				c = c.getNext();
			}
		}
		return a;
	}

	private static void printList(ListNode head) {
		System.out.println("");
		ListNode current = head;
		while (current != null) {
			System.out.print(current.getData());
			current = current.getNext();
		}
	}
}
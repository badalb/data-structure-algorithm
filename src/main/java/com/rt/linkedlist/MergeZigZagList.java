package com.rt.linkedlist;

public class MergeZigZagList {

	public static void main(String[] args) {
		ListNode head1 = createFirstList();
		ListNode head2 = createSecondList();
		ListNode head = zigzagMerge(head1, head2, true);
		printList(head);
	}

	private static ListNode zigzagMerge(ListNode a, ListNode b, boolean flag) {
		ListNode result = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		if (flag) {
			result = a;
			result.setNext(zigzagMerge(a.getNext(), b, !flag));
		} else {
			result = b;
			result.setNext(zigzagMerge(a, b.getNext(), !flag));
		}

		return result;
	}

	private static ListNode createFirstList() {
		ListNode head = new ListNode(2);
		ListNode three = new ListNode(3);
		head.setNext(three);

		ListNode seven = new ListNode(7);
		three.setNext(seven);
		ListNode ten = new ListNode(10);
		seven.setNext(ten);
		return head;
	}

	private static ListNode createSecondList() {
		ListNode head = new ListNode(1);
		ListNode five = new ListNode(5);
		head.setNext(five);

		ListNode six = new ListNode(6);
		five.setNext(six);
		ListNode nine = new ListNode(9);
		six.setNext(nine);
		return head;
	}

	private static void printList(ListNode head) {
		System.out.println("");
		ListNode current = head;
		while (current != null) {
			System.out.print(" " +current.getData());
			current = current.getNext();
		}
	}
}

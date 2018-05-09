package com.rt.linkedlist;

public class ReverseAddLinkedList {

	public static void main(String[] args) {
		ListNode fhead = createFirstList();
		ListNode shead = createSecondList();

		int carry = 0;
		ListNode head = addListData(fhead, shead, carry);
		printList(head);
	}

	private static ListNode addListData(ListNode fhead, ListNode shead, int carry) {

		if (fhead == null && shead == null && carry == 0) {
			return null;
		}

		if (fhead == null && shead == null && carry != 0) {
			return new ListNode(carry);
		}

		ListNode result = new ListNode();

		int sum = carry + (fhead != null ? fhead.getData() : 0) + (shead != null ? shead.getData() : 0);
		carry = sum / 10;
		result.setData(sum % 10);
		result.setNext(addListData(fhead != null ? fhead.getNext() : null,
				shead.getNext() != null ? shead.getNext() : null, carry));
		return result;
	}

	private static ListNode createSecondList() {
		ListNode head = new ListNode(7);
		ListNode one = new ListNode(1);
		head.setNext(one);
		ListNode six = new ListNode(6);
		one.setNext(six);

		return head;
	}

	private static ListNode createFirstList() {
		ListNode head = new ListNode(5);
		ListNode nine = new ListNode(9);
		head.setNext(nine);
		ListNode two = new ListNode(2);
		nine.setNext(two);

		return head;
	}

	private static void printList(ListNode head) {
		System.out.println("");
		ListNode current = head;
		while (current != null) {
			System.out.print(" " + current.getData());
			current = current.getNext();
		}
	}
}

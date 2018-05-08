package com.rt.linkedlist;

public class PartitionListByKey {

	public static void main(String[] args) {
		ListNode three = new ListNode(3);
		ListNode fiveone = new ListNode(5);
		ListNode fivetwo = new ListNode(5);
		ListNode eight = new ListNode(8);
		ListNode ten = new ListNode(10);
		ListNode two = new ListNode(2);
		ListNode one = new ListNode(1);

		ListNode head = three;
		three.setNext(fiveone);
		fiveone.setNext(eight);
		eight.setNext(fivetwo);
		fivetwo.setNext(ten);
		ten.setNext(two);
		two.setNext(one);
		printList(head);
		head = partition(head, 5);
		printList(head);
	}

	private static ListNode partition(ListNode head, int key) {
		ListNode iterator = head;
		ListNode smallFirst = null;
		ListNode smallLast = null;
		ListNode grterFirst = null;
		ListNode grterLast = null;

		while (iterator != null) {
			if (iterator.getData() < key) {
				if (smallFirst == null) {
					smallFirst = iterator;
					smallLast = iterator;
				} else {
					smallLast.setNext(iterator);
					smallLast = iterator;
				}
			} else {
				if (grterFirst == null) {
					grterFirst = iterator;
					grterLast = iterator;
				} else {
					grterLast.setNext(iterator);
					grterLast = iterator;
				}
			}

			iterator = iterator.getNext();
		}
		smallLast.setNext(grterFirst);
		grterLast.setNext(null);
		return smallFirst;
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

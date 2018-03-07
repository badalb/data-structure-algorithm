package com.test.practice;

import com.test.linkedlist.Node;;

public class MainClass {

	public static void main(String[] args) {
		LinkList linkedList = new LinkList();
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 7));
		linkedList.insertEnd(new Node(null, 9));
		linkedList.printList(linkedList.getHead());

		linkedList.reverse();
		linkedList.printList(linkedList.getHead());

		linkedList.reverse(linkedList.getHead(), null);
		linkedList.printList(linkedList.getHead());
	}
}

package com.test.linkedlist;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Remving from empty list");
		LinkedList emptyList = new LinkedList();
		emptyList.removeNodeWithKey(5);

		System.out.println("Remving from single node list");
		LinkedList singleNode = new LinkedList(new Node(null, 5));
		singleNode.removeNodeWithKey(5);
		singleNode.printList(singleNode.getHead());

		System.out.println("Remving single node list");
		LinkedList list = new LinkedList(new Node(null, 7));
		list.insertEnd(new Node(null, 11));
		list.removeNodeWithKey(5);
		list.printList(list.getHead());

		System.out.println("Creating a list");
		LinkedList linkedList = new LinkedList();
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 7));
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 9));
		linkedList.insertEnd(new Node(null, 11));
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 13));
		linkedList.insertEnd(new Node(null, 5));
		linkedList.insertEnd(new Node(null, 5));
		System.out.println("Printing list ........");
		linkedList.printList(linkedList.getHead());
		System.out.println("");
		System.out.println("Start removing nodes ........");

		linkedList.removeNodeWithKey(5);
		linkedList.printList(linkedList.getHead());
	}

}

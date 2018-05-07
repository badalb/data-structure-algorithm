package com.rt.stackqueue;

import com.rt.linkedlist.ListNode;

public class MyListStack {

	private ListNode top;

	public MyListStack() {
		top = null;
	}

	public boolean push(int data) {
		ListNode temp = new ListNode(data);
		temp.setNext(top);
		top = temp;
		return true;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Empty Stack");
			return Integer.MIN_VALUE;
		}
		int data = top.getData();
		top = top.getNext();
		return data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		MyListStack mystack = new MyListStack();
		mystack.push(3);
		mystack.push(8);
		System.out.println(mystack.pop());
		mystack.push(1);
		mystack.push(5);
		while (!mystack.isEmpty()) {
			System.out.println(mystack.pop());
		}
	}

}

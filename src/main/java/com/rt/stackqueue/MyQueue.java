package com.rt.stackqueue;

import com.rt.linkedlist.ListNode;

public class MyQueue {

	private ListNode front;
	private ListNode rear;

	public MyQueue() {
		front = rear = null;
	}

	public boolean push(int data) {
		ListNode node = new ListNode(data);
		if (front == null && rear == null) {
			front = rear = node;
		} else {
			rear.setNext(node);
			rear = node;
		}
		return true;
	}

	public int pop() {
		int data = Integer.MIN_VALUE;
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return data;
		}

		if (front == rear) {
			data = front.getData();
			front = rear = null;
		} else {
			data = front.getData();
			front = front.getNext();
		}
		return data;
	}

	public boolean isEmpty() {
		return front == null && rear == null;
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		System.out.println(queue.pop());
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}

}

package com.test.practice;

public class Stack {

	private int maxSize;
	private int[] stack;
	int top = -1;

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	public boolean push(int data) {
		if (isFull()) {
			System.out.println("Full Stack !!!");
			return false;
		}
		top++;
		stack[top] = data;
		return true;
	}

	public int top() {
		return stack[top];
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Empty Stack !!!!!");
			return -1;
		}
		int data = stack[top];
		top--;
		return data;
	}

	private boolean isFull() {
		return top + 1 >= maxSize ? true : false;
	}

	private boolean isEmpty() {
		return top < 0 ? true : false;
	}

}

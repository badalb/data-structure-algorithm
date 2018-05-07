package com.rt.stackqueue;

public class MyStack {

	private int[] arr;
	private int[] minarr;
	private int top;
	private int mintop = -1;

	public MyStack() {
		arr = new int[100];
		minarr = new int[100];
		top = -1;
	}

	public boolean push(int x) {
		if (top == arr.length - 1) {
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++top] = x;

		if (mintop == -1 || minarr[mintop] >= x) {
			minarr[++mintop] = x;
		}
		return true;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}

		int value = arr[top--];
		if (minarr[mintop] == value) {
			mintop--;
		}
		return value;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return arr[top];
	}

	public int getMin() {
		return minarr[mintop];
	}

	public static void main(String[] args) {
		MyStack mystack = new MyStack();
		mystack.push(3);
		mystack.push(8);
		System.out.println("Min :" + mystack.getMin());
		System.out.println(mystack.pop());
		mystack.push(1);
		mystack.push(5);
		while (!mystack.isEmpty()) {
			System.out.println("Min :" + mystack.getMin());
			System.out.println(mystack.pop());
		}
	}

}

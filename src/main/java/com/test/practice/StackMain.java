package com.test.practice;

public class StackMain {

	public static void main(String[] args) {
		Stack stack = new Stack(2);
		stack.pop();
		stack.push(5);
		stack.push(7);
		System.out.println(stack.top());
		stack.push(9);
	}

}

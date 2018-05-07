package com.rt.stackqueue;

import java.util.Stack;

public class SwapStacks {

	public static void swap(Stack<Integer> s1, Stack<Integer> s2) {
		swap(s1, s2, s1.size(), s2.size());
	}

	private static void swap(Stack<Integer> s1, Stack<Integer> s2, int lenS1, int lenS2) {

		if (s1.isEmpty() && s2.isEmpty()) {
			return;
		}

		int s1Elem = 0, s2Elem = 0;

		if (!s1.isEmpty()) {
			s1Elem = s1.pop();
		}
		if (!s2.isEmpty()) {
			s2Elem = s2.pop();
		}
		
		swap(s1, s2);

		if (s1.size() < lenS2) {
			s1.add(s2Elem);
		}
		if (s2.size() < lenS1) {
			s2.add(s1Elem);
		}
	}

	public static void main(String[] args) {

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		s1.add(1);
		s1.add(2);
		s1.add(3);

		s2.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);

		System.out.println("s1 -> " + s1);
		System.out.println("s2 -> " + s2);

		swap(s1, s2);

		System.out.println("s1 -> " + s1);
		System.out.println("s2 -> " + s2);
	}
}
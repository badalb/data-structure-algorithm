package com.rt.linkedlist;

import java.util.Stack;

public class PalindromeList {

	public static void main(String[] args) {
		ListNode head = createList();
		checkPalidrome(head);
	}

	private static void checkPalidrome(ListNode head) {
		ListNode slowptr = head;
		ListNode fastptr = head;
		Stack<Integer> stack = new Stack<>();
		
		while(fastptr.getNext() !=null){
			int data = slowptr.getData();
			stack.push(data);
			slowptr = slowptr.getNext();
			fastptr = fastptr.getNext().getNext();
		}
		
		slowptr = slowptr.getNext();
		while(slowptr !=null){
			int data = slowptr.getData();
			if(stack.pop() != data){
				System.out.println("Not palindrome");
			}
			slowptr = slowptr.getNext();
		}
		
		System.out.println("Palindrome");
	}

	private static ListNode createList() {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		head.setNext(two);
		ListNode five = new ListNode(5);
		two.setNext(five);
		ListNode nine = new ListNode(9);
		five.setNext(nine);
		ListNode sfive = new ListNode(5);
		nine.setNext(sfive);
		ListNode stwo = new ListNode(2);
		sfive.setNext(stwo);
		ListNode sone = new ListNode(1);
		stwo.setNext(sone);
		return head;
	}

}

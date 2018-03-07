package com.test.stack;

public class ReverseString {

	public static void main(String[] args) {

		String s = "abcdefgh";
		// java.util.Stack<Character> stack = new java.util.Stack();
		// for(char c : s.toCharArray()){
		// stack.push(c);
		// }
		//
		// int size = stack.size();
		//
		// for(int i = 0; i< size; i++){
		// System.out.println(stack.pop());
		// }
		//
		char[] ca = s.toCharArray();
		int j = ca.length - 1;

		for (int i = 0; i < j; i++, j--) {
			char temp = ca[i];
			ca[i] = ca[j];
			ca[j] = temp;
		}

		String rev = new String(ca);
		System.out.println(rev);

	}

}

package com.test.tree;

public class SumAllNode {

	private static int findSum(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		return root.getData() + findSum(root.getLeftChild()) + findSum(root.getRightChild());
	}

	public static void main(String[] args) {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> seven = new Node<Integer>(7);

		one.setLeftChild(two);
		one.setRightChild(three);

		two.setLeftChild(four);
		two.setRightChild(five);

		three.setLeftChild(six);
		three.setRightChild(seven);
		System.out.println("Sum of all nodes :" + findSum(one));
	}

}

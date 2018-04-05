package com.test.tree;

public class ReverseLevelTraversal {

	private static int height(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lheight = height(root.getLeftChild());
		int rhight = height(root.getRightChild());
		return lheight > rhight ? lheight + 1 : rhight + 1;
	}

	private static void printReverseLevel(Node<Integer> root) {
		for (int i = height(root); i >= 0; i--) {
			printNode(root, i);
		}
	}

	private static void printNode(Node<Integer> root, int height) {
		if (root == null) {
			return;
		}
		if (height == 1) {
			System.out.println(root.getData());
		} else {
			printNode(root.getLeftChild(), height - 1);
			printNode(root.getRightChild(), height - 1);
		}
	}

	public static void main(String[] args) {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> seven = new Node<Integer>(7);
		Node<Integer> eight = new Node<Integer>(8);

		one.setLeftChild(two);
		one.setRightChild(three);

		two.setLeftChild(four);
		two.setRightChild(five);

		three.setLeftChild(six);
		three.setRightChild(seven);
		seven.setRightChild(eight);

		printReverseLevel(one);
	}

}

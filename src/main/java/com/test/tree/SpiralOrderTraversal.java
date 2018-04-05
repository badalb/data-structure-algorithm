package com.test.tree;

import java.util.Stack;

public class SpiralOrderTraversal {

	private static void zigzagTraversal(Node root) {
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();

		currentLevel.push(root);
		boolean leftToright = false;

		while (!currentLevel.isEmpty()) {

			Node node = currentLevel.pop();
			System.out.println(node.getData());

			if (leftToright) {
				if (node.getLeftChild() != null) {
					nextLevel.push(node.getLeftChild());
				}
				if (node.getRightChild() != null) {
					nextLevel.push(node.getRightChild());
				}
			} else {
				if (node.getRightChild() != null) {
					nextLevel.push(node.getRightChild());
				}

				if (node.getLeftChild() != null) {
					nextLevel.push(node.getLeftChild());
				}

			}

			if (currentLevel.isEmpty()) {
				leftToright = !leftToright;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
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
		zigzagTraversal(one);
	}

}

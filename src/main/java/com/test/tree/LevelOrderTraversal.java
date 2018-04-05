package com.test.tree;

import java.util.LinkedList;

public class LevelOrderTraversal {

	private static void levelOrderTraversal(Node<Integer> root) {
		java.util.Queue<Node<Integer>> queue = new LinkedList<>();
		if (root == null) {
			return;
		}
		queue.add(root);

		while (!queue.isEmpty()) {
			Node<Integer> node = queue.poll();
			System.out.println(node.getData());
			if (node.getLeftChild() != null) {
				queue.add(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				queue.add(node.getRightChild());
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
		
		levelOrderTraversal(one);
	}
}

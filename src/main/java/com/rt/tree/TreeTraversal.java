package com.rt.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

	public static void main(String[] args) {
		TNode root = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);

		root.setLeft(two);
		root.setRight(three);

		two.setLeft(four);
		four.setRight(six);
		three.setRight(five);
		five.setRight(seven);

		System.out.println("Inorder Traversal: ");
		printInorder(root);
		System.out.println();
		System.out.println("PreOrder Travresal: ");
		printPreOrder(root);
		System.out.println();
		System.out.println("PostOrder Traversal");
		printPostOrder(root);
		System.out.println();
		System.out.println("Level Order Traversal: ");
		levelOrderTraversal(root);
		System.out.println();
		System.out.println("Level Order Traversal with level :");
		leveledLevelOrderTraversal(root);
	}

	private static void leveledLevelOrderTraversal(TNode node) {

		if (node == null) {
			return;
		}

		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(node);
		queue.add(new TNode(Integer.MIN_VALUE));

		while (!queue.isEmpty()) {
			TNode temp = queue.remove();
			if (temp.getData() != Integer.MIN_VALUE) {
				System.out.print(temp.getData());

				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}

				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}
			} else {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(new TNode(Integer.MIN_VALUE));
				}
			}
		}
	}

	private static void levelOrderTraversal(TNode node) {
		if (node == null) {
			return;
		}

		Queue<TNode> queue = new LinkedList<TNode>();
		queue.add(node);

		while (!queue.isEmpty()) {
			TNode temp = queue.remove();
			System.out.print(temp.getData());

			if (temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}

			if (temp.getRight() != null) {
				queue.add(temp.getRight());
			}
		}

	}

	private static void printPostOrder(TNode node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.getLeft());
		printPostOrder(node.getRight());
		System.out.print(node.getData());

	}

	private static void printPreOrder(TNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.getData());
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());

	}

	private static void printInorder(TNode node) {

		if (node == null) {
			return;
		}

		printInorder(node.getLeft());
		System.out.print(node.getData());
		printInorder(node.getRight());
	}

}

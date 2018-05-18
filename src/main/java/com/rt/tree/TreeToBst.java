package com.rt.tree;

import java.util.Arrays;

public class TreeToBst {

	private static int i = 0;

	public static void main(String[] args) {
		TNode root = new TNode(3);
		TNode four = new TNode(4);
		TNode one = new TNode(1);
		root.setLeft(four);
		root.setRight(one);
		TNode five = new TNode(5);
		one.setLeft(five);
		TNode two = new TNode(2);
		TNode eight = new TNode(8);
		four.setLeft(eight);
		four.setRight(two);

		int size = totalNoOfNodes(root);
		int[] elements = new int[size];
		traverseInOrder(root, elements);
		System.out.println("");
		// printElements(elements);
		Arrays.sort(elements);
		i = 0;
		createBST(elements, root);
		traverseInOrder(root);
	}

	private static void createBST(int[] elements, TNode node) {
		if (node == null) {
			return;
		}
		createBST(elements, node.getLeft());
		node.setData(elements[i]);
		i++;
		createBST(elements, node.getRight());
	}

	// private static void printElements(int[] a) {
	// for (int i = 0; i < a.length; i++) {
	// System.out.print(" " + a[i]);
	// }
	// }

	private static int totalNoOfNodes(TNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + totalNoOfNodes(node.getLeft()) + totalNoOfNodes(node.getRight());
	}

	private static void traverseInOrder(TNode node, int[] a) {

		if (node == null) {
			return;
		}
		traverseInOrder(node.getLeft(), a);
		System.out.print(" " + node.getData());
		a[i] = node.getData();
		i++;
		traverseInOrder(node.getRight(), a);
	}

	private static void traverseInOrder(TNode node) {

		if (node == null) {
			return;
		}
		traverseInOrder(node.getLeft());
		System.out.print(" " + node.getData());
		traverseInOrder(node.getRight());
	}
}

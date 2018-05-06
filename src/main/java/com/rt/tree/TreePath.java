package com.rt.tree;

public class TreePath {

	public static void main(String[] args) {
		TNode root = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);
		TNode eight = new TNode(8);

		root.setLeft(two);
		root.setRight(three);

		two.setLeft(four);
		two.setRight(eight);
		four.setRight(six);
		three.setRight(five);
		five.setRight(seven);
		int[] path = new int[100];
		printPath(root, 0, path);
	}

	private static void printPath(TNode node, int pos, int[] path) {

		if (node == null) {
			return;
		}

		if (node.getLeft() == null && node.getRight() == null) {
			path[pos] = node.getData();
			printArray(path, pos);
		} else {
			path[pos] = node.getData();
		}

		printPath(node.getLeft(), pos + 1, path);
		printPath(node.getRight(), pos + 1, path);
	}

	private static void printArray(int[] path, int pos) {
		System.out.println();
		for (int i = 0; i <= pos; i++) {
			System.out.print(path[i]);
		}
	}

}

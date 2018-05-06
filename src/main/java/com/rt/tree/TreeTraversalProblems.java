package com.rt.tree;

public class TreeTraversalProblems {

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

		System.out.println("Sum of nodes :" + sumOfAllNodes(root));
		System.out.println("No of leaf nodes :" + noOfLeafNodes(root));
		System.out.println("Height:" + heightOfTree(root));

		System.out.println("Ancesters of 6 :");
		printAncestors(root, 6);
	}

	private static boolean printAncestors(TNode node, int x) {

		if (node == null) {
			return false;
		}

		if (node.getData() == x) {
			return true;
		}

		if (printAncestors(node.getLeft(), x) || printAncestors(node.getRight(), x)) {
			System.out.print(node.getData());
			return true;
		}

		return false;
	}

	private static int heightOfTree(TNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(heightOfTree(node.getLeft()), heightOfTree(node.getRight()));
	}

	private static int noOfLeafNodes(TNode node) {

		if (node == null) {
			return 0;
		}

		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}

		return noOfLeafNodes(node.getLeft()) + noOfLeafNodes(node.getRight());
	}

	private static int sumOfAllNodes(TNode node) {

		if (node == null) {
			return 0;
		}

		return node.getData() + sumOfAllNodes(node.getLeft()) + sumOfAllNodes(node.getRight());
	}

}

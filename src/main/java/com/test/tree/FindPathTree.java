package com.test.tree;

public class FindPathTree {

	private static void printPath(Node<Integer> root) {
		findAllPath(root, new int[100], 0);
	}

	private static void findAllPath(Node<Integer> root, int[] path, int pathLength) {
		if (root == null) {
			return;
		}

		if (root.getLeftChild() == null && root.getRightChild() == null) {
			path[pathLength++] = root.getData();
			System.out.println(" Path :");
			for (int i = 0; i < pathLength; i++) {
				System.out.println(path[i]);
			}
			System.out.println();
			path = new int[100];
		}

		path[pathLength++] = root.getData();
		findAllPath(root.getLeftChild(), path, pathLength);
		findAllPath(root.getRightChild(), path, pathLength);

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

		printPath(one);
	}

}

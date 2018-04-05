package com.test.tree;

public class LeftViewOfTree {

	private static int max_level = 0;
	private static int rt_max_level = 0;

	private static void leftView(Node<Integer> one) {
		int level = 1;
		printLeftView(one, level);
	}

	private static void printLeftView(Node<Integer> root, int level) {
		if (root == null) {
			return;
		}

		if (max_level < level) {
			System.out.println(root.getData());
			max_level = level;
		}
		printLeftView(root.getLeftChild(), level + 1);
		printLeftView(root.getRightChild(), level + 1);
	}

	private static void printRightView(Node<Integer> root, int level) {
		if (root == null) {
			return;
		}

		if (rt_max_level < level) {
			System.out.println(root.getData());
			rt_max_level = level;
		}
		printRightView(root.getRightChild(), level + 1);
		printRightView(root.getLeftChild(), level + 1);
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
		System.out.println("Print Left View :");
		leftView(one);

		System.out.println("Print Right View :");
		printRightView(one, 1);
	}

}

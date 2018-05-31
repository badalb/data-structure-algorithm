package com.rt.sorting.heapsort;

public class CompleteBinaryTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		root.left = two;
		root.right = three;
		two.right = four;
		three.left = five;
		three.right = six;
		two.left = seven;
		System.out.println("Complete ?" + (isComplete(root) && leafAtSameLevel(root, 0, -1)));
	}

	private static boolean isComplete(Node r) {

		if (r == null)
			return true;

		if (r.left == null && r.right == null)
			return true;

		if (r.left == null || r.right == null)
			return false;

		return (isComplete(r.left) && isComplete(r.right));

	}

	private static boolean leafAtSameLevel(Node r, int level, int LL) {

		if (r == null)
			return true;

		if (r.left == null && r.right == null) {

			if (LL != -1) {
				if (level == LL) {
					return true;
				} else {
					return false;
				}
			} else {
				LL = level;
			}
		}

		return (leafAtSameLevel(r.left, level + 1, LL) && leafAtSameLevel(r.right, level + 1, LL));

	}
}

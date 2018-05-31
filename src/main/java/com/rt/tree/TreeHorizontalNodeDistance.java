package com.rt.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHorizontalNodeDistance {
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
		Node root = createTree();
		int k1 = 1;
		int k2 = 9;
		System.out.println("Horizontal Distance: " + leveledLevelOrderTraversal(root, k1, k2));
	}

	private static int leveledLevelOrderTraversal(Node node, int k1, int k2) {

		int i = -1;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		queue.add(new Node(Integer.MIN_VALUE));

		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			if (temp.getData() != Integer.MIN_VALUE) {

				if (temp.getData() == k1 || temp.getData() == k2) {
					if (i == -1) {
						i++;
					} else {
						return i;
					}
				} else if (i >= 0) {
					i++;
				}

				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				} else {
					queue.add(new Node(-1));
				}

				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				} else {
					queue.add(new Node(-1));
				}
			} else {
				if (!queue.isEmpty()) {
					queue.add(new Node(Integer.MIN_VALUE));
				}
			}
		}
		return -1;
	}

	private static Node createTree() {
		Node root = new Node(4);
		Node three = new Node(3);
		Node two = new Node(2);
		Node one = new Node(1);
		Node nine = new Node(9);
		Node eleven = new Node(11);
		root.left = three;
		root.right = two;
		three.left = one;
		two.right = nine;
		nine.left = eleven;
		return root;
	}

}

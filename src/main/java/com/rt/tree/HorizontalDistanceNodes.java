package com.rt.tree;

import java.util.LinkedList;
import java.util.Queue;

//
//Given a binary tree and two numbers (which represents two nodes in a tree) as input and are at the same level, 
//write a program to find out distance between those two nodes. 
//Distance between two nodes at a same level in a binary tree is defined as the number of nodes that would have 
//existed between the two given nodes, had it been a complete binary tree.
//
//For example, in the following binary tree, distance between 1 and 9 would be 2. That is because if the following 
//tree would have been a complete binary tree, it would have a right node at 3 and left node at 2, both of which would 
//be existing between 1 and 9.
//
//
//                                                        4 
//                                                      /    \
//                                                     3      2         
//                                                    / \     / \
//                                                    1          9
//                                                                \ 
//                                                                 11
//                                                                  \
//                                                                   12



public class HorizontalDistanceNodes {

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
		int level = findLevel(root, k1, k2, 0);
		System.out.println("Horizontal Distance: " + leveledLevelOrderTraversal(root, level, k1, k2));
	}

	private static int findLevel(Node root, int k1, int k2, int level) {

		if (root == null) {
			return 0;
		}

		if (root.getData() == k1 || root.getData() == k2) {
			return level;
		}

		int llevel = findLevel(root.getLeft(), k1, k2, level + 1);
		int rlevel = findLevel(root.getRight(), k1, k2, level + 1);
		return llevel != 0 ? llevel : rlevel;
	}

	private static int leveledLevelOrderTraversal(Node node, int level, int k1, int k2) {
		int l = 0;
		int i = -1;
		if (node == null) {
			return -1;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		queue.add(new Node(Integer.MIN_VALUE));

		while (!queue.isEmpty() && l <= level) {
			Node temp = queue.remove();
			if (temp.getData() != Integer.MIN_VALUE) {
				if (l == level) {
					if (temp.getData() == k1 || temp.getData() == k2) {
						if (i < 0) {
							i = 0;
						} else {
							return i;
						}
					} else {
						i++;
					}
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
				l++;
				//System.out.println();
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


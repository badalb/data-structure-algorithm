package com.test.tree;

public class DistnaceNode {

	static class Node {

		private int data;

		private Node leftChild;

		private Node rightChild;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	}

	public static void main(String[] args) {
		Node four = new Node(4);
		Node three = new Node(3);
		Node two = new Node(2);
		four.setLeftChild(three);
		four.setRightChild(two);

		Node one = new Node(1);
		three.setLeftChild(one);

		Node five = new Node(5);
		two.setRightChild(five);

		Node six = new Node(6);
		five.setLeftChild(six);
		findDistnace(four, 1, 5);
	}

	private static void findDistnace(Node four, int n1, int n2) {
		int level = findDepth(four, n1, 0);
		System.out.println(level);
		levelOrderTraversal(four, level);
		
	}

	private static void levelOrderTraversal(Node four, int level) {
		
	}

	
	
	private static int findDepth(Node root, int n1, int depth) {

		if (root == null) {
			return 0;
		}

		if (root.getData() == n1) {
			return depth;
		}

		int lDepth = findDepth(root.getLeftChild(), n1, depth + 1);
		if (lDepth != 0) {
			return lDepth;
		} else {
			return findDepth(root.getLeftChild(), n1, depth + 1);
		}
	}

}

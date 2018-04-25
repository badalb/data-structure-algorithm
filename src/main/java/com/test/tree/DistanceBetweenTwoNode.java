package com.test.tree;

public class DistanceBetweenTwoNode {

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
		Node eight = new Node(8);
		Node three = new Node(3);
		Node ten = new Node(10);

		eight.setLeftChild(three);
		eight.setRightChild(ten);

		Node one = new Node(1);
		three.setLeftChild(one);

		Node six = new Node(6);
		Node fourteen = new Node(14);
		ten.setLeftChild(six);
		ten.setRightChild(fourteen);

		Node thirteen = new Node(13);
		fourteen.setLeftChild(thirteen);

		Node four = new Node(4);
		Node seven = new Node(7);

		six.setLeftChild(four);
		six.setRightChild(seven);

		Node lca = findLCA(eight, 4, 13);
		int distance = getDistance(lca, 4, 0) + getDistance(lca, 13, 0);
		System.out.println("Distance:" + distance);
	}

	private static Node findLCA(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.getData() == n1 || node.getData() == n2) {
			return node;
		}

		Node leftLCA = findLCA(node.getLeftChild(), n1, n2);
		Node rightLCA = findLCA(node.getRightChild(), n1, n2);

		if (leftLCA != null && rightLCA != null) {
			return node;
		}

		return leftLCA != null ? leftLCA : rightLCA;
	}

	private static int getDistance(Node node, int n, int depth) {
		if (node == null) {
			return -1;
		}
		
		if (node.getData() == n) {
			return depth;
		}

		int lDistance = getDistance(node.getLeftChild(), n, depth + 1);
		int rDistance = getDistance(node.getRightChild(), n, depth + 1);

		return lDistance != -1 ? lDistance : rDistance;
	}
}

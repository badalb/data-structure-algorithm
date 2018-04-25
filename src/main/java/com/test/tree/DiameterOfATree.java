package com.test.tree;

public class DiameterOfATree {

	private static int H = -1;

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

		System.out.println("Diameter of the tree:" + Math.max(H, findDiameter(eight)));
	}

	private static int findDiameter(Node node) {

		if (node == null) {
			return 0;
		}

		int lheight = findDiameter(node.getLeftChild());
		int rheight = findDiameter(node.getRightChild());

		H = Math.max(H, lheight + rheight + 1);
		return Math.max(lheight, rheight) + 1;
	}

}

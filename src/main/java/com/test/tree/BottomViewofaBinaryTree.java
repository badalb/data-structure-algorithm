package com.test.tree;

public class BottomViewofaBinaryTree {

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
		Node root = new Node(1);

		Node two = new Node(2);
		Node three = new Node(3);

		root.setLeftChild(two);
		root.setRightChild(three);

		Node four = new Node(4);
		Node five = new Node(5);
		Node eight = new Node(8);
		Node nine = new Node(9);

		two.setLeftChild(four);
		two.setRightChild(five);

		four.setLeftChild(eight);
		four.setRightChild(nine);

		Node six = new Node(6);
		Node seven = new Node(7);
		three.setLeftChild(six);
		three.setRightChild(seven);

		Node twelve = new Node(12);
		Node thirteen = new Node(13);
		Node fourteen = new Node(14);
		Node fifteen = new Node(15);

		six.setLeftChild(twelve);
		six.setRightChild(thirteen);

		seven.setLeftChild(fourteen);
		seven.setRightChild(fifteen);
		printBottomView(root);
	}

	private static void printBottomView(Node node) {
		if (node != null) {
			printBottomView(node.getLeftChild());
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println(node.getData());
			}
			printBottomView(node.getRightChild());
		}
	}

}

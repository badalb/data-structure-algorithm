package com.test.tree;

public class BSTMain {

	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.getLeftChild());
		System.out.println(root.getData() + " ");
		inOrder(root.getRightChild());
	}

	public static void main(String[] args) {
		Node rootNode = new Node(40);
		BinarySearchTree bst = new BinarySearchTree(rootNode);
		Node root = createBinarySearchTree(bst, rootNode);
		inOrder(root);
		bst.deleteNode(root, 50);
		System.out.println("-------");
		inOrder(root);
	}

	public static Node createBinarySearchTree(BinarySearchTree bst, Node rootNode) {

		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		Node node5 = new Node(5);
		Node node13 = new Node(13);
		Node node55 = new Node(55);

		// insert(null, rootNode);
		bst.insert(rootNode, node20);
		bst.insert(rootNode, node10);
		bst.insert(rootNode, node30);
		bst.insert(rootNode, node60);
		bst.insert(rootNode, node50);
		bst.insert(rootNode, node70);
		bst.insert(rootNode, node5);
		bst.insert(rootNode, node13);
		bst.insert(rootNode, node55);
		return rootNode;
	}
}

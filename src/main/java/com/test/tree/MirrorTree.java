package com.test.tree;

public class MirrorTree {

	public static Node mirrorTree(Node node) {

		if (node == null) {
			return node;
		}

		Node left = mirrorTree(node.getLeftChild());
		Node right = mirrorTree(node.getRightChild());

		node.setLeftChild(right);
		node.setRightChild(left);
		return node;
	}

	private static boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null && root2 != null || root1 != null && root2 == null) {
			return false;
		}

		return (root1.getData() == root2.getData()) && (isMirror(root1.getLeftChild(), root2.getRightChild())
				&& isMirror(root1.getRightChild(), root2.getLeftChild()));
	}

	public static void main(String[] args) {

		Node originalTree = createTree();
		Node mirror = mirrorTree(originalTree);

		System.out.println("Mirror: ");
		BinaryTree.inorderTraversal(mirror);
		originalTree = createTree();
		System.out.println("Original");
		BinaryTree.inorderTraversal(originalTree);

		System.out.println("Mirror Image :" + isMirror(mirror, originalTree));
	}

	private static Node createTree() {
		Node<Integer> root = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);

		root.setLeftChild(three);
		root.setRightChild(two);
		two.setLeftChild(five);
		two.setRightChild(four);

		return root;
	}
}

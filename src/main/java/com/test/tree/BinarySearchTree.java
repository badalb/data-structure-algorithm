package com.test.tree;

public class BinarySearchTree {

	private Node<Integer> root;

	public BinarySearchTree() {

	}

	public BinarySearchTree(Node root) {
		this.root = root;
	}

	public Node<Integer> insert(Node<Integer> root, Node<Integer> node) {
		if (root == null) {
			this.root = node;
			return root;
		}

		if (root.getData() > node.getData()) {
			if (root.getLeftChild() == null) {
				root.setLeftChild(node);
			} else {
				insert(root.getLeftChild(), node);
			}

		} else if (root.getData() < node.getData()) {
			if (root.getRightChild() == null) {
				root.setRightChild(node);
			} else {
				insert(root.getRightChild(), node);
			}
		}

		return root;
	}

	public boolean deleteNode(Node<Integer> node, Integer key) {

		if (node == null) {
			return false;
		}

		if (node.getData() > key) {
			deleteNode(node.getLeftChild(), key);
		} else if (node.getData() < key) {
			deleteNode(node.getRightChild(), key);
		} else {
			if (node.getLeftChild() != null && node.getRightChild() != null) {
				Node<Integer> temp = node;
				Node<Integer> minNode = findMinimumNode(node).getLeftChild();
				temp.setData(temp.getData());
				deleteNode(minNode, minNode.getData());
				return true;
			} else if (node.getLeftChild() != null) {
				node = node.getLeftChild();
				return true;
			} else if (node.getRightChild() != null) {
				node = node.getRightChild();
				return true;
			} else {
				node = null;
				return true;
			}

		}
		return false;
	}

	public Node<Integer> findMinimumNode(Node<Integer> node) {
		if (node == null) {
			return null;
		}
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			return node;
		} else {
			return findMinimumNode(node.getLeftChild());
		}
	}

	public Node<Integer> getRoot() {
		return root;
	}

}

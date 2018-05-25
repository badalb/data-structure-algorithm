package com.rt.sorting.mergesort;

public class MergeBinarySearchTree {

	static class Node<T> {
		private T data;
		private Node<T> leftChild;
		private Node<T> rightChild;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public Node<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}

		public Node<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 7, 10, 15 };
		int[] b = { 3, 9, 11, 20 };
		int[] c = new int[a.length + b.length];

		merge(a, a.length, b, b.length, c);
		int mid = 0 + a.length / 2;
		Node<Integer> root = insert(null, new Node<Integer>(c[mid]));

		for (int i = 0; i < mid - 1; i++) {
			insert(root, new Node<Integer>(c[i]));
		}

		for (int i = mid + 1; i < c.length; i++) {
			insert(root, new Node<Integer>(c[i]));
		}
		inorderTraversal(root);
	}

	private static void merge(int[] a, int n, int[] b, int m, int[] c) {
		int i, j, k;
		i = j = k = 0;

		while (i < n && j < m) {
			if (a[i] < b[j]) {

				c[k++] = a[i++];
			} else {

				c[k++] = b[j++];
			}
		}

		while (i < n) {
			c[k++] = a[i++];
		}

		while (j < m) {
			c[k++] = b[j++];
		}

	}

	private static Node<Integer> insert(Node<Integer> root, Node<Integer> node) {
		if (root == null) {
			root = node;
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

	private static void inorderTraversal(Node<?> node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.getLeftChild());
		System.out.println(node.getData());
		inorderTraversal(node.getRightChild());
	}
}

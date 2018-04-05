package com.test.tree;

public class LowestCommonAncestor {

	private static Node<Integer> findLCA(Node<Integer> root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.getData() == n1 || root.getData() == n2) {
			return root;
		}

		Node<Integer> leftLCA = findLCA(root.getLeftChild(), n1, n2);
		Node<Integer> rightLCA = findLCA(root.getRightChild(), n1, n2);

		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		return leftLCA != null ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> seven = new Node<Integer>(7);

		one.setLeftChild(two);
		one.setRightChild(three);

		two.setLeftChild(four);
		two.setRightChild(five);

		three.setLeftChild(six);
		three.setRightChild(seven);

		Node<Integer> lca = findLCA(one, 4, 6);
		System.out.println(" Lowest Common Ancester:" + lca.getData());

		Node<Integer> lca1 = findLCA(one, 1, 6);
		System.out.println(" Lowest Common Ancester:" + lca1.getData());
	}

}

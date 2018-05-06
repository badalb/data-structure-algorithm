package com.rt.tree;

public class CreateTree {

	private static int preindex = 0;

	public static void main(String[] args) {
		int[] inorder = { 4, 6, 2, 1, 3, 5, 7 };
		int[] preorder = { 1, 2, 4, 6, 3, 5, 7 };

		TNode root = createBinaryTree(inorder, preorder, 0, inorder.length - 1);
		printInorder(root);
	}

	private static TNode createBinaryTree(int[] inorder, int[] preorder, int instart, int inend) {

		if (instart > inend) {
			return null;
		}

		int nodeData = preorder[preindex++];
		TNode node = new TNode(nodeData);

		if (instart == inend) {
			return node;
		}

		int inorderIndex = findIndex(inorder, nodeData);

		node.setLeft(createBinaryTree(inorder, preorder, instart, inorderIndex - 1));
		node.setRight(createBinaryTree(inorder, preorder, inorderIndex + 1, inend));
		return node;
	}

	private static int findIndex(int[] inorder, int data) {

		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == data) {
				return i;
			}
		}
		return -1;
	}

	private static void printInorder(TNode node) {

		if (node == null) {
			return;
		}

		printInorder(node.getLeft());
		System.out.print(node.getData());
		printInorder(node.getRight());
	}
}

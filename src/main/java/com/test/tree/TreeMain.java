package com.test.tree;

import com.test.tree.Queue.QueueOverflowException;
import com.test.tree.Queue.QueueUnderflowException;

public class TreeMain {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		Node<Character> root = new Node<>('A');
		Node<Character> b = new Node<>('B');
		Node<Character> c = new Node<>('C');
		Node<Character> d = new Node<>('D');
		Node<Character> e = new Node<>('E');
		Node<Character> f = new Node<>('F');
		Node<Character> g = new Node<>('G');
		Node<Character> h = new Node<>('H');
		Node<Character> x = new Node<>('X');
		Node<Character> y = new Node<>('Y');
		Node<Character> z = new Node<>('Z');

		root.setLeftChild(b);
		root.setRightChild(c);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		// e.setRightChild(g);
		b.setLeftChild(x);
		x.setRightChild(y);
		y.setLeftChild(z);
		// BinaryTree.breadthFirst(root);
		// BinaryTree.inorderTraversal(root);
		// BinaryTree.verticalOrderTraversal(root);
		BinaryTree.printPath(root);

		System.out.println(BinaryTree.maxDepth(root));
	}

}

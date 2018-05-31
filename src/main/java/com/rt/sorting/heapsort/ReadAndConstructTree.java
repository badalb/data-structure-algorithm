package com.rt.sorting.heapsort;

import java.util.LinkedList;
import java.util.Queue;

public class ReadAndConstructTree {

	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		root.left = two;
		root.right = three;
		two.right = four;
		three.left = five;
		three.right = six;
		five.left = seven;

		int depth = maxDepth(root);
		int maxNode = (int) (Math.pow(2, depth) - 1);
		int[] a = new int[maxNode];
		leveledLevelOrderTraversal(root, a, depth);
		// System.out.println(a);
		
		Node newroot = new Node(a[0]);
		insertLevelOrder(newroot, a, 0);
		printPreOrder(root);
		printPreOrder(newroot);
	}

	private static void insertLevelOrder(Node root, int[] a, int i)
	{
	    if(root == null ){ return; }
	 
	    int left = 2*i+1;
	    if(left < a.length && a[left] != -1)
	    {
	        root.left = new Node(a[left]);
	        insertLevelOrder(root.left, a, 2*i+1);
	    }
	  
	   int right = 2*i+2;
	    if(right < a.length && a[right] != -1)
	    {
	        root.right= new Node(a[right]);
	        insertLevelOrder(root.right, a, 2*i+2);
	    }
	}

	private static void leveledLevelOrderTraversal(Node node, int[] a, int maxlevel) {

		int l = 0;
		int i = 0;

		if (node == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		queue.add(new Node(Integer.MIN_VALUE));

		while (!queue.isEmpty() && l < maxlevel) {
			Node temp = queue.remove();
			if (temp.getData() != Integer.MIN_VALUE) {
				// System.out.print(" " + temp.getData());
				a[i++] = temp.getData();
				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				} else {
					queue.add(new Node(-1));
				}

				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				} else {
					queue.add(new Node(-1));
				}
			} else {
				l++;
				// System.out.println();
				if (!queue.isEmpty()) {
					queue.add(new Node(Integer.MIN_VALUE));
				}
			}
		}
	}

	private static void printPreOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.getData());
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());

	}

	public static int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
}

package com.rt.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderLinkedList {

	private static int max_level = -1;

	public static class TN {

		private int data;

		private TN left;

		private TN right;

		private TN next;

		public TN(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TN getLeft() {
			return left;
		}

		public void setLeft(TN left) {
			this.left = left;
		}

		public TN getRight() {
			return right;
		}

		public void setRight(TN right) {
			this.right = right;
		}

		public TN getNext() {
			return next;
		}

		public void setNext(TN next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		TN one = new TN(1);
		TN two = new TN(2);
		TN three = new TN(3);
		TN five = new TN(5);
		TN six = new TN(6);
		TN seven = new TN(7);
		TN eight = new TN(8);
		TN nine = new TN(9);

		five.setLeft(six);
		five.setRight(eight);
		six.setLeft(two);
		two.setRight(nine);
		eight.setLeft(one);
		eight.setRight(seven);
		one.setRight(three);
		leveledLevelOrderTraversal(five);
		System.out.println("Done");
		printLeftView(five, 0);

	}

	private static void printLeftView(TN node, int level) {
		if (node == null) {
			return;
		}

		if (max_level < level) {
			System.out.println();
			System.out.print(node.getData());
			TN temp = node.getNext();
			while (temp != null) {
				System.out.print(temp.getData());
				temp = temp.getNext();
			}
			max_level = level;
		}
		printLeftView(node.getLeft(), level + 1);
		printLeftView(node.getRight(), level + 1);
	}

	private static void leveledLevelOrderTraversal(TN node) {

		if (node == null) {
			return;
		}

		Queue<TN> queue = new LinkedList<TN>();
		queue.add(node);
		queue.add(new TN(Integer.MIN_VALUE));

		while (!queue.isEmpty()) {
			TN temp = queue.remove();

			if (temp.getData() != Integer.MIN_VALUE) {
				System.out.print(temp.getData());

				// next pointer
				TN next = queue.peek();
				if (next.getData() != Integer.MIN_VALUE) {
					temp.setNext(next);
				} // else default null

				if (temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}

				if (temp.getRight() != null) {
					queue.add(temp.getRight());
				}

			} else {
				System.out.println();
				if (!queue.isEmpty()) {
					queue.add(new TN(Integer.MIN_VALUE));
				}
			}
		}
	}
}

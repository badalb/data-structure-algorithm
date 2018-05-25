package com.rt.sorting.mergesort;

public class MergePathSumLinkedList {

	static class Node {
		private int data;
		private Node next;

		public Node() {
		}

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

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Node one = new Node(1);
		Node three = new Node(3);
		Node seven = new Node(7);
		Node nine = new Node(9);

		one.setNext(three);
		three.setNext(seven);
		seven.setNext(nine);
		Node fHead = one;

		Node zero = new Node(0);
		Node thre2 = new Node(3);
		Node five = new Node(5);
		Node seven2 = new Node(7);
		Node eight = new Node(8);

		zero.setNext(thre2);
		thre2.setNext(five);
		five.setNext(seven2);
		seven2.setNext(eight);
		Node sHead = zero;
		Node resultHead = formMaxSumMergedList(fHead, sHead);

		while (resultHead != null) {
			System.out.print(" " + resultHead.getData());
		}
	}

	private static Node formMaxSumMergedList(Node fh, Node sh) {

		Node result = null;
		Node fpre = fh;
		Node fcur = fh;
		Node spre = sh;
		Node scur = sh;

		while (fcur != null || scur != null) {
			int fsum = 0;
			int ssum = 0;
			while (fcur != null && scur != null && fcur.getData() != scur.getData()) {
				if (fcur.getData() > scur.getData()) {
					fsum += fcur.getData();
					fcur = fcur.getNext();
				} else {
					ssum += scur.getData();
					scur = scur.getNext();
				}
			}

			if (fcur == null) {
				while (scur != null) {
					ssum += scur.getData();
					scur = scur.getNext();
				}
			}
			if (scur == null) {
				while (fcur != null) {
					fsum += fcur.getData();
					fcur = fcur.getNext();
				}
			}

			if (fpre == fh && spre == sh) {
				result = fsum > ssum ? fpre : spre;
			} else {
				if (fsum > ssum)
					spre.next = fpre.next;
				else
					fpre.next = spre.next;
			}

			fpre = fcur;
			spre = scur;

			if (fcur != null)
				fcur = fcur.next;

			if (scur != null)
				scur = scur.next;

		}

		return result;
	}

}

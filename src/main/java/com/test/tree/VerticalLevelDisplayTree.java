package com.test.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VerticalLevelDisplayTree {

	private static void printVertically(Node<Integer> root, Map<Integer, List<Node<Integer>>> result, int level) {
		if (root == null) {
			return;
		}

		LinkedList<Node<Integer>> list = (LinkedList<Node<Integer>>) result.get(level);
		if (list == null) {
			list = new LinkedList<Node<Integer>>();
		}

		list.add(root);
		result.put(level, list);

		printVertically(root.getLeftChild(), result, level - 1);
		printVertically(root.getRightChild(), result, level + 1);
	}

	public static void main(String[] args) {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> seven = new Node<Integer>(7);
		Node<Integer> eight = new Node<Integer>(8);

		one.setLeftChild(two);
		one.setRightChild(three);

		two.setLeftChild(four);
		two.setRightChild(five);

		three.setLeftChild(six);
		three.setRightChild(seven);
		seven.setRightChild(eight);

		Map<Integer, List<Node<Integer>>> result = new HashMap<>();
		printVertically(one, result, 0);
		for (Map.Entry<Integer, List<Node<Integer>>> e : result.entrySet()) {
			System.out.println(" Nodes at level :" + e.getKey());
			for (Node<Integer> n : e.getValue()) {
				System.out.println(n.getData());
			}
		}
	}

}

package com.test.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversalofBinaryTree {

	static class Node {

		private int data;

		private Node leftChild;

		private Node rightChild;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	}

	public static void main(String[] args) {
		Node eight = new Node(8);
		Node three = new Node(3);
		Node ten = new Node(10);

		eight.setLeftChild(three);
		eight.setRightChild(ten);

		Node one = new Node(1);
		three.setLeftChild(one);

		Node six = new Node(6);
		Node fourteen = new Node(14);
		ten.setLeftChild(six);
		ten.setRightChild(fourteen);

		Node thirteen = new Node(13);
		fourteen.setLeftChild(thirteen);

		Node four = new Node(4);
		Node seven = new Node(7);

		six.setLeftChild(four);
		six.setRightChild(seven);

		Map<Integer, List<Integer>> nodesMap = new HashMap<Integer, List<Integer>>();
		printDiagonalView(eight, 0, nodesMap);
		
		System.out.println("Diagonal View :");
		
		for(Map.Entry<Integer,List<Integer>> entry: nodesMap.entrySet()){
			System.out.println(entry.getValue());
		}
	}

	private static void printDiagonalView(Node node, int level, Map<Integer, List<Integer>> nodesMap) {
		if (node == null) {
			return;
		}

		if (nodesMap.get(level) != null) {
			nodesMap.get(level).add(node.getData());
		} else {
			List<Integer> nodesList = new ArrayList<>();
			nodesList.add(node.getData());
			nodesMap.put(level, nodesList);
		}

		printDiagonalView(node.getLeftChild(), level + 1, nodesMap);
		printDiagonalView(node.getRightChild(), level, nodesMap);
	}

}

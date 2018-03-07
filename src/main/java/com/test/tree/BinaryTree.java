package com.test.tree;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.tree.Queue.QueueOverflowException;
import com.test.tree.Queue.QueueUnderflowException;

public class BinaryTree {

	public static void breadthFirst(Node<?> root) throws QueueOverflowException, QueueUnderflowException {
		if (root == null) {
			return;
		}

		System.out.println(root.getData());
		Queue<Node> queue = new Queue<>(Node.class);
		queue.enqueue(root.getLeftChild());
		queue.enqueue(root.getRightChild());
		while (!queue.isEmpty()) {
			Node<Character> node = queue.dequeue();
			System.out.println(node.getData());
			if (node.getLeftChild() != null) {
				queue.enqueue(node.getLeftChild());
			}
			if (node.getRightChild() != null) {
				queue.enqueue(node.getRightChild());
			}
		}
	}

	public static void inorderTraversal(Node<?> node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.getLeftChild());
		System.out.println(node.getData());
		inorderTraversal(node.getRightChild());
	}

	public static void verticalOrderTraversal(Node<?> root) {
		int level = 0;
		Map<Integer, List<Node>> traverseMap = new HashMap<>();
		traverseVertically(root, level, traverseMap);
		Map<Object, Integer> map = traverseMap.entrySet().stream()
				.flatMap(e -> e.getValue().stream().map(v -> new AbstractMap.SimpleImmutableEntry<>(e.getKey(), v)))
				.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

		map.forEach((k, v) -> {
			System.out.println(k + ":" + v);
		});
	}

	private static void traverseVertically(Node node, int level, Map<Integer, List<Node>> traverseMap) {

		if (node != null) {
			List<Node> nodeList = traverseMap.get(level);
			if (nodeList != null) {
				nodeList.add(node);
			} else {
				nodeList = new LinkedList<>();
				nodeList.add(node);
				traverseMap.put(level, nodeList);
			}

			traverseVertically(node.getLeftChild(), level--, traverseMap);
			traverseVertically(node.getRightChild(), level++, traverseMap);
		}
	}

	public static void printPath(Node<Character> root) {
		char[] paths = new char[10];
		findPath(root, paths, 0);
	}

	private static void findPath(Node<Character> node, char[] path, int length) {
		if (node == null) {
			return;
		}
		path[length] = node.getData();
		length++;

		if (node.getLeftChild() == null && node.getRightChild() == null) {
			for (int i = 0; i < length; i++) {
				System.out.println(path[i]);
			}
			System.out.println("----");
			return;
		}

		findPath(node.getLeftChild(), path, length);
		findPath(node.getRightChild(), path, length);
	}

	public static int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.getLeftChild());
			int rDepth = maxDepth(node.getRightChild());

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
}

package com.rt.tree;

public class EvaluateExpression {

	static class ExNode {
		private String data;
		private ExNode left;
		private ExNode right;

		public ExNode(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public ExNode getLeft() {
			return left;
		}

		public void setLeft(ExNode left) {
			this.left = left;
		}

		public ExNode getRight() {
			return right;
		}

		public void setRight(ExNode right) {
			this.right = right;
		}
	}

	public static void main(String[] args) {
		ExNode star = new ExNode("*");
		ExNode plus = new ExNode("+");
		ExNode minus = new ExNode("-");
		ExNode two = new ExNode("2");
		ExNode three = new ExNode("3");
		ExNode five = new ExNode("5");
		ExNode eight = new ExNode("8");

		star.setLeft(plus);
		star.setRight(minus);
		plus.setLeft(two);
		plus.setRight(three);

		minus.setLeft(eight);
		minus.setRight(five);

		System.out.println(" Value:" + eval(star));
	}

	private static int eval(ExNode node) {
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return Integer.valueOf(node.getData());
		}
		int lvalue = eval(node.getLeft());
		int rvalue = eval(node.getRight());

		String data = node.getData();
		if (data.equals("+")) {
			return lvalue + rvalue;
		} else if (data.equals("-")) {
			return lvalue - rvalue;
		} else if (data.equals("*")) {
			return lvalue * rvalue;
		} else {
			return lvalue / rvalue;
		}
	}
}

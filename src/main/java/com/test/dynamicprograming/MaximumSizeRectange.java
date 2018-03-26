package com.test.dynamicprograming;

public class MaximumSizeRectange {

	public static void main(String[] args) {
		int rowCount = 4;
		int colCount = 4;

		int[][] arr = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		System.out.print("Area of maximum rectangle is " + maxRectangle(rowCount, colCount, arr));
	}

	private static int maxRectangle(int rowCount, int colCount, int[][] arr) {
		int result = maxHist(arr[0]);
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++)
				if (arr[i][j] == 1) {
					arr[i][j] += arr[i - 1][j];
				}
			result = Math.max(result, maxHist(arr[i]));
		}
		return result;
	}

	private static int maxHist(int[] hist) {
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		int i = 0;
		int top = 0;
		int maxArea = 0;
		while (i < hist.length) {
			if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i);
				i++;
			} else {
				top = stack.peek();
				stack.pop();
				int currentMax = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
				if (maxArea < currentMax) {
					maxArea = currentMax;
				}
			}
		}

		while (stack.empty() == false) {
			top = stack.peek();
			stack.pop();
			int currentMax = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);

			if (maxArea < currentMax) {
				maxArea = currentMax;
			}
		}
		return maxArea;
	}
}

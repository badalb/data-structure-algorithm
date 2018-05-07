package com.rt.stackqueue;

public class LargestAreaHistogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area :" + calcMaxArea(hist, hist.length));
	}

	private static int calcMaxArea(int[] hist, int length) {
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

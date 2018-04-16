package com.test.binheap;

public class MedianRunningInteger {

	public static void main(String[] args) {
		int[] arr = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		printMedian(arr);
	}

	private static void printMedian(int[] arr) {
		MaxHeap left = new MaxHeap(1000);
		MinHeap right = new MinHeap(1000);
		int currentMedian = 0;
		for (int i = 0; i < arr.length; i++) {
			currentMedian = getMedian(arr[i], currentMedian, left, right);
			System.out.println("Running Median:" + currentMedian);
		}

	}

	private static int getMedian(int currentElement, int currentMedian, MaxHeap left, MinHeap right) {

		int diff = Math.subtractExact(left.getCount(), right.getCount());
		int median = 0;
		switch (diff) {
		case 1:
			if (currentElement < currentMedian) {
				right.insert(left.removeHighestPriority());
				left.insert(currentElement);
			} else {
				right.insert(currentElement);
			}
			median = (left.getData(0) + right.getData(0)) / 2;
			break;

		case 0:
			if (currentElement < currentMedian) {
				left.insert(currentElement);
				median = left.getData(0);
			} else {
				right.insert(currentElement);
				median = right.getData(0);
			}
			break;

		case -1:

			if (currentElement < currentMedian) {
				left.insert(currentElement);
			} else {

				left.insert(right.removeHighestPriority());
				right.insert(currentElement);
			}
			median = (left.getData(0) + right.getData(0)) / 2;
			break;
		}
		return median;
	}

}

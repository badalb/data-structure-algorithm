package com.test.binheap;

public class BinaryHeap {

	private int MAX_SIZE;
	private int count;

	private int[] heap;

	public int getData(int index) {
		return heap[index];
	}

	public int getLeftChild(int index) {
		int childIndex = index * 2 + 1;
		if (childIndex >= count) {
			return -1;
		}
		return childIndex;
	}

	public int getRightChildIndex(int index) {
		int childIndex = index * 2 + 2;
		if (childIndex >= count) {
			return -1;
		}
		return childIndex;
	}

	public int getParent(int index) {
		if (index < 0 || index >= MAX_SIZE) {
			return -1;
		}
		int parentIndex = (index - 1) / 2;
		return parentIndex;
	}

	private void swap(int fIndex, int toIndex) {
		int temp = heap[fIndex];
		heap[fIndex] = heap[toIndex];
		heap[toIndex] = temp;
	}

	private void shiftDown(int index) {
		int leftChildIndex = getLeftChild(index);
		int rihgtChildIndex = getRightChildIndex(index);

		int smallestIndex = -1;
		if (leftChildIndex != -1 && rihgtChildIndex != -1) {
			if (getData(leftChildIndex) > getData(rihgtChildIndex)) {
				smallestIndex = rihgtChildIndex;
			} else if (getData(leftChildIndex) < getData(rihgtChildIndex)) {
				smallestIndex = leftChildIndex;
			}
		} else if (leftChildIndex != -1) {
			smallestIndex = leftChildIndex;
		} else if (rihgtChildIndex != -1) {
			smallestIndex = rihgtChildIndex;
		}

		if (smallestIndex == -1) {
			return;
		}

		if (getData(smallestIndex) < getData(index)) {
			swap(smallestIndex, index);
			shiftDown(smallestIndex);
		}
	}

	private void shiftUp(int index) {
		int parentIndex = getParent(index);
		if (parentIndex != -1 && getData(index) < getData(parentIndex)) {
			swap(index, parentIndex);
			shiftUp(parentIndex);
		}

	}

	public void insert(int value) {
		if (count >= heap.length) {
			System.out.println("Heap is full");
		}

		heap[count] = value;
		shiftUp(count);

		count++;
	}

	public int removeHighestPriority() {
		int min = getHighestPriority();

		heap[0] = heap[count - 1];
		count--;
		shiftDown(0);

		return min;
	}

	private int getHighestPriority() {
		return heap[0];
	}

	public void printHeap() {
		for (int data : heap) {
			System.out.println(data);
		}
	}

}

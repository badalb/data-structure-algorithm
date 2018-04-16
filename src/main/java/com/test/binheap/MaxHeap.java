package com.test.binheap;

public class MaxHeap {

	private int count;
	private int maxSize;
	private int[] heap;

	public MaxHeap(int maxSize) {
		heap = new int[maxSize];
		this.maxSize = maxSize;
	}

	public int getCount() {
		return count;
	}

	public int getParent(int index) {
		if (index < 0 || index >= maxSize) {
			return -1;
		}
		int parentIndex = (index - 1) / 2;
		return parentIndex;
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

	public int getData(int index) {
		return heap[index];
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
		int min = heap[0];
		heap[0] = heap[count - 1];
		count--;

		shiftDown(0);
		return min;
	}

	public void printHeap() {
		for (int data : heap) {
			System.out.println(data);
		}
	}

	private void shiftDown(int index) {
		int leftChildIndex = getLeftChild(index);
		int rihgtChildIndex = getRightChildIndex(index);

		int largestIndex = -1;
		if (leftChildIndex != -1 && rihgtChildIndex != -1) {
			if (getData(leftChildIndex) > getData(rihgtChildIndex)) {
				largestIndex = leftChildIndex;
			} else if (getData(leftChildIndex) < getData(rihgtChildIndex)) {
				largestIndex = rihgtChildIndex;
			}
		} else if (leftChildIndex != -1) {
			largestIndex = leftChildIndex;
		} else if (rihgtChildIndex != -1) {
			largestIndex = rihgtChildIndex;
		}

		if (largestIndex == -1) {
			return;
		}

		if (getData(largestIndex) > getData(index)) {
			swap(largestIndex, index);
			shiftDown(largestIndex);
		}
	}

	private void shiftUp(int index) {
		int parentIndex = getParent(index);
		if (parentIndex != -1 && getData(index) > getData(parentIndex)) {
			swap(index, parentIndex);
			shiftUp(parentIndex);
		}
	}

	private void swap(int fIndex, int toIndex) {
		int temp = heap[fIndex];
		heap[fIndex] = heap[toIndex];
		heap[toIndex] = temp;
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(10);
		maxHeap.insert(10);
		maxHeap.insert(70);
		maxHeap.insert(40);
		maxHeap.insert(20);
		maxHeap.insert(30);
		maxHeap.printHeap();

		System.out.println("Remove :" + maxHeap.removeHighestPriority());
		System.out.println("Remove :" + maxHeap.removeHighestPriority());
		System.out.println("Remove :" + maxHeap.removeHighestPriority());

	}

}

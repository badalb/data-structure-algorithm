package com.test.binheap;

public class MinHeap {

	private int count;
	private int maxSize;
	private int[] heap;

	public MinHeap(int maxSize) {
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

	private void swap(int fIndex, int toIndex) {
		int temp = heap[fIndex];
		heap[fIndex] = heap[toIndex];
		heap[toIndex] = temp;
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(10);
		minHeap.insert(10);
		minHeap.insert(70);
		minHeap.insert(40);
		minHeap.insert(20);
		minHeap.insert(30);
		minHeap.printHeap();

		System.out.println("Remove :" + minHeap.removeHighestPriority());
		System.out.println("Remove :" + minHeap.removeHighestPriority());
		System.out.println("Remove :" + minHeap.removeHighestPriority());
		System.out.println("Remove :" + minHeap.removeHighestPriority());
	}

}

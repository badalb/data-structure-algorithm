package com.test.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 1, 25, 3, 11, 18 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(array, low, middle);
			mergeSort(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}

	private static void merge(int[] array, int low, int middle, int high) {
		int[] helper = new int[array.length];
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int leftSubIndex = low;
		int rightSubIndex = middle + 1;
		int current = low;

		while (leftSubIndex <= middle && rightSubIndex <= high) {
			if (helper[leftSubIndex] <= helper[rightSubIndex]) {
				array[current] = helper[leftSubIndex];
				leftSubIndex++;
			} else {
				array[current] = helper[rightSubIndex];
				rightSubIndex++;
			}
			current++;
		}

		int remaining = middle - leftSubIndex;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[leftSubIndex + i];
		}

	}
}

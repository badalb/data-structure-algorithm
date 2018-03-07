package com.test.queue;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 5, 11, 4, 2, 10, 3, 7, 8, 9 };
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}

	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivotIndex = partition(arr, low, high);
		quickSort(arr, low, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, high);
	}

	private static int partition(int[] arr, int low, int high) {
		int l = low;
		int h = high;
		int pivot = arr[low];

		while (l < h) {
			while (arr[l] <= pivot && l < h) {
				l++;
			}
			while (arr[h] > pivot) {
				h--;
			}
			if (l < h) {
				swap(arr, l, h);
			}
		}
		swap(arr, low, h);
		return h;
	}

	public static void swap(int[] arr, int iIndex, int jIndex) {
		int temp = arr[iIndex];
		arr[iIndex] = arr[jIndex];
		arr[jIndex] = temp;
	}
}

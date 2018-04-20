package com.test.sort;

public class PancakeSorting {

	public static void main(String[] args) {
		int arr[] = { 23, 10, 20, 11, 12, 6, 7 };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = findMaxIndex(arr, n);
			if (idx != n - 1) {
				flip(arr, idx);
				flip(arr, n - 1);
			}
			n--;
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void flip(int[] arr, int index) {
		int start = 0;
		while (start < index) {
			int temp = arr[index];
			arr[index] = arr[start];
			arr[start] = temp;
			start++;
			index--;
		}
	}

	private static int findMaxIndex(int[] arr, int n) {
		int maxIdx = 0;
		for (int i = 0; i < n; i++) {
			if (arr[maxIdx] < arr[i]) {
				maxIdx = i;
			}
		}
		return maxIdx;
	}
}

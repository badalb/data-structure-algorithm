package com.rt.sorting.quicksort;

/**
 * Given an unsorted array of size n, find minimum length subarray, sorting
 * which makes entire array sorted. If input array is int arr = {5, 7, 15, 12,
 * 9, 35, 52, 80} then sorting the underlined subarray sorts the entire array.
 * 
 * @author badalb
 *
 */
public class UnsortedSubArray {

	public static void main(String[] args) {
		// int[] a = { 5, 7, 10, 15, 42, 9, 35, 52, 80 };
		int[] a = { 5, 7, 15, 12, 9, 35, 52, 80 };
		int low = findLowIdx(a);
		int high = findHighIdx(a);
		printSubarray(a, low, high);

	}

	private static int findLowIdx(int[] a) {
		int i = 0;
		while (a[i] < a[i + 1] && i < a.length - 1) {
			i++;
		}
		return i;
	}

	private static int findHighIdx(int[] a) {
		int i = a.length - 1;
		while (a[i] > a[i - 1] && i > 1) {
			i--;
		}
		return i;
	}

	private static void printSubarray(int[] a, int low, int high) {
		int min = findMin(a, low, high);
		int max = findMax(a, low, high);

		int i = low;
		while (a[i] >= min && i >= 0) {
			i--;
		}

		int j = high;
		while (a[j] <= max) {
			j++;
		}

		System.out.println("Subarray :");

		for (int k = i + 1; k <= j - 1; k++) {
			System.out.print(" " + a[k]);
		}
	}

	private static int findMin(int[] a, int low, int high) {
		int min = a[low];
		for (int i = low + 1; i <= high; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}

	private static int findMax(int[] a, int low, int high) {
		int max = a[low];
		for (int i = low + 1; i <= high; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

}

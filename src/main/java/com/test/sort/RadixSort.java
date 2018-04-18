package com.test.sort;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		radixsort(arr);
		print(arr);
	}

	private static void radixsort(int[] arr) {

		int max = maxElement(arr);
		for (int exp = 1; max / exp > 0; exp *= 10)
			countSort(arr, arr.length, exp);
	}

	private static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int count[] = new int[10];

		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10] = count[(arr[i] / exp) % 10] + 1;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		
		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static int maxElement(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

}

package com.test.array;

import java.util.Arrays;

public class SortInWaveForm {

	public static void main(String[] args) {
		int[] arr = { 10, 90, 49, 2, 1, 5, 23 };
		sortArrayinWaveForm(arr);
	}

	private static void sortArrayinWaveForm(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i = i + 2) {
			swap(arr, i, i + 1);
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
	}

}

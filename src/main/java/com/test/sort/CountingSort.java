package com.test.sort;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		System.out.println("Before Sorting : ");
		int arr[] = { 8,5,3,1,5,8,3 };
		System.out.println(Arrays.toString(arr));
		arr = countingSort(arr);
		System.out.println("=======================");
		System.out.println("After Sorting : ");
		System.out.println(Arrays.toString(arr));
	}

	private static int[] countingSort(int[] array) {
		int n = array.length;
		int result[] = new int[n];
		int[] counts = new int[9];

		for (int i = 0; i < 9; i++) {
			counts[i] = 0;
		}

		for (int j = 0; j < n; j++) {
			++counts[array[j]];
		}

		for (int i = 1; i < 9; ++i) {
			counts[i] += counts[i - 1];
		}

		for (int k = 0; k < n; k++) {
			System.out.println(array[k] + " ----" + counts[array[k]] );
			System.out.println((counts[array[k]] - 1) + " ----" + array[k]);
			result[counts[array[k]] - 1] = array[k];
			--counts[array[k]];
			System.out.println( "++++"  +counts[array[k]]);
		}
		return result;
	}
}

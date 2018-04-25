package com.test.array;

import java.util.Arrays;

public class Sum2Intgers3rd {

	public static void main(String[] args) {
		int[] arr = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
		findTriplet(arr, arr.length);

	}

	private static void findTriplet(int[] arr, int n) {
		Arrays.sort(arr);

		for (int i = n - 1; i >= 0; i--) {
			int k = i - 1;
			int j = 0;
			while (j < k) {
				if (arr[k] + arr[j] == arr[i]) {
					System.out.println("numbers are " + arr[i] + " " + arr[j] + " " + arr[k]);
					return;
				} else if (arr[i] > arr[j] + arr[k])
					j += 1;
				else
					k -= 1;
			}

		}
		System.out.println("Does not exists");
	}
}

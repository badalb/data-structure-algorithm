package com.rt.array;

public class MajorityElement {

	private static int findMajorityElement(int[] arr, int size) {
		int count = 0, i, majorityElement = 0;
		for (i = 0; i < size; i++) {
			if (count == 0)
				majorityElement = arr[i];
			if (arr[i] == majorityElement)
				count++;
			else
				count--;
		}
		count = 0;
		for (i = 0; i < size; i++)
			if (arr[i] == majorityElement)
				count++;
		if (count > size / 2)
			return majorityElement;
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 2, 2, 4, 7, 2, 2, 2, 1, 2 };
		System.out.println(findMajorityElement(arr, arr.length));

	}

}

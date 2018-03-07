package com.test.hash;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

	private static void findPair(int[] arr) {
		Map<Integer, Pair> sumPairMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (sumPairMap.containsKey(sum)) {
					Pair pair = sumPairMap.get(sum);
					System.out.println(
							"(" + arr[i] + "," + arr[j] + ")" + " ---- " + "(" + pair.getFirst() + "," + pair.getLast() + ")");
				} else {
					sumPairMap.put(sum, new Pair(arr[i], arr[j]));
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {3, 4, 7, 1, 2, 9, 8};
		findPair(a);
	}

	static class Pair {
		int first;
		int last;

		Pair(int first, int last) {
			this.first = first;
			this.last = last;
		}

		public int getFirst() {
			return first;
		}

		public int getLast() {
			return last;
		}
	}
}

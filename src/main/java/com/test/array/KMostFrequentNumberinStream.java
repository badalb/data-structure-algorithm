package com.test.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KMostFrequentNumberinStream {

	public static List<Entry<Integer, Integer>> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}

		List<Entry<Integer, Integer>> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k = 4;
		List<Entry<Integer, Integer>> elements = topKFrequent(a, k);
		for (Entry<Integer, Integer> entry : elements) {
			System.out.println(" Element :" + entry.getKey() + " Frequency :" + entry.getValue());
		}
	}

}

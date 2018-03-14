package com.test.recursion;

public class GroupSum {

	public static boolean groupSum(int start, int[] nums, int target) {
		if (start >= nums.length) {
			return target == 0;
		}
		return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 8 };
		System.out.println(groupSum(0, a, 10));

	}

}

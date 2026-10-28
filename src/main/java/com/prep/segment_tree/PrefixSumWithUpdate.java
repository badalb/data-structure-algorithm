package com.prep.segment_tree;

// In fact, a prefix sum array is usually better than a segment tree if the array never changes.
// We use a segment tree when we need efficient queries and updates.

public class PrefixSumWithUpdate {

    private final int[] arr;
    private final long[] prefix;

    public PrefixSumWithUpdate(int[] nums) {
        arr = nums.clone();
        prefix = new long[arr.length + 1];

        buildPrefix();
    }

    private void buildPrefix() {
        prefix[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
    }

    // Update arr[index] to newValue
    public void update(int index, int newValue) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }

        long difference = (long) newValue - arr[index];

        arr[index] = newValue;

        // All prefix sums after this index are affected.
        for (int i = index + 1; i < prefix.length; i++) {
            prefix[i] += difference;
        }
    }

    // Inclusive range sum: arr[left] + ... + arr[right]
    public long sumRange(int left, int right) {
        if (left < 0 || right >= arr.length || left > right) {
            throw new IndexOutOfBoundsException();
        }

        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4, 7, 6, 8};

        PrefixSumWithUpdate ps = new PrefixSumWithUpdate(nums);

        System.out.println(ps.sumRange(2, 5)); // 19

        ps.update(3, 10); // Change index 3 from 3 to 10

        System.out.println(ps.sumRange(2, 5)); // 26
        System.out.println(ps.sumRange(0, 7)); // 43
    }
}


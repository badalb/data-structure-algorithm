package com.prep.segment_tree;

public class SegmentTree {
    private final int n;
    private final int[] tree;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] arr, int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(arr, node * 2, left, mid);
        build(arr, node * 2 + 1, mid + 1, right);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int query(int queryLeft, int queryRight) {
        return query(1, 0, n - 1, queryLeft, queryRight);
    }

    private int query(int node, int left, int right,
                      int queryLeft, int queryRight) {

        // Case 1: No overlap
        if (right < queryLeft || left > queryRight) {
            return 0;
        }

        // Case 2: Complete overlap
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        // Case 3: Partial overlap
        int mid = left + (right - left) / 2;

        int leftSum = query(node * 2, left, mid,
                queryLeft, queryRight);

        int rightSum = query(node * 2 + 1, mid + 1, right,
                queryLeft, queryRight);

        return leftSum + rightSum;
    }

    public void update(int index, int newValue) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException();
        }

        update(1, 0, n - 1, index, newValue);
    }

    private void update(int node, int left, int right,
                        int index, int newValue) {

        // Base case: reached the leaf for this index
        if (left == right) {
            tree[node] = newValue;
            return;
        }

        int mid = left + (right - left) / 2;

        // Follow only the branch containing the index
        if (index <= mid) {
            update(node * 2, left, mid, index, newValue);
        } else {
            update(node * 2 + 1, mid + 1, right, index, newValue);
        }

        // Recalculate this parent from its children
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        SegmentTree st = new SegmentTree(arr);

        System.out.println("Total sum: " + st.tree[1]); // 78

        System.out.println(st.query(2, 8)); // 42
        System.out.println(st.query(0, 5)); // 21
        System.out.println(st.query(6, 11)); // 57

        st.update(3, 10);

        System.out.println(st.query(2, 5)); // 24
        System.out.println(st.query(0, 11)); // 84
    }
}

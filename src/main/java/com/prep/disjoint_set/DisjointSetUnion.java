package com.prep.disjoint_set;


import java.util.Arrays;

public class DisjointSetUnion {

    private final int[] parent;
    private final int[] size;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Find the root with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Merge groups using union by size
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // Already in the same group
        if (rootX == rootY) {
            return false;
        }

        // Ensure rootX belongs to the larger group
        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootY] = rootX;
        size[rootX] += size[rootY];

        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(5);

        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);

        System.out.println(dsu.connected(0, 2)); // true
        System.out.println(dsu.connected(0, 4)); // false
        System.out.println(dsu.connected(3, 4)); // true

        System.out.println(Arrays.toString(dsu.parent));
    }
}


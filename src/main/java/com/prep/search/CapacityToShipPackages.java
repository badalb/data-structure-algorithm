package com.prep.search;

public class CapacityToShipPackages {

    // this is binary search on answer
    public static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        // packages can't be split so min weight should
        // be equal to max weight of a single package

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid;       // Try a smaller capacity
            } else {
                low = mid + 1;    // Capacity is too small
            }
        }

        return low;
    }

    private static boolean canShip(
            int[] weights, int days, int capacity) {

        int daysNeeded = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }

            currentLoad += weight;

            if (daysNeeded > days) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
        // Output: 15
    }
}

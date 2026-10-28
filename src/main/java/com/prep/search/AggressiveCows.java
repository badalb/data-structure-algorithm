package com.prep.search;

import java.util.Arrays;

public class AggressiveCows {

    public static int maxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                answer = mid;      // Feasible: try a larger distance
                low = mid + 1;
            } else {
                high = mid - 1;    // Infeasible: reduce distance
            }
        }

        return answer;
    }

    private static boolean canPlaceCows(
            int[] stalls, int cows, int distance) {

        int cowsPlaced = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                cowsPlaced++;
                lastPosition = stalls[i];

                if (cowsPlaced >= cows) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;

        System.out.println(maxMinDistance(stalls, cows));
        // Output: 3
        // Distance:  1  2  3  4  5  6  7  8
        // Feasible:  Y  Y  Y  N  N  N  N  N
        // If distance d is feasible, every smaller distance is feasible too.
        // If distance d is not feasible, every larger distance is also impossible.
    }
}
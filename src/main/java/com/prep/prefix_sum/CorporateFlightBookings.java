package com.prep.prefix_sum;

import java.util.Arrays;

public class CorporateFlightBookings {
    public static int[] corpFlightBookings(
            int[][] bookings, int n) {

        int[] diff = new int[n + 1];

        // Record each booking as two boundary changes
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            diff[first - 1] += seats;
            diff[last] -= seats;
        }

        // Reconstruct total seats using prefix sums
        int[] answer = new int[n];
        int runningSum = 0;

        for (int i = 0; i < n; i++) {
            runningSum += diff[i];
            answer[i] = runningSum;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;

        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };

        System.out.println(Arrays.toString(
                corpFlightBookings(bookings, n)
        ));
    }
}

package com.prep.prefix_sum;

public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {

        int[] diff = new int[1001];

        // Record passenger pickup and drop-off events
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passengers;
            diff[to] -= passengers;
        }

        // Track the number of passengers in the car
        int passengersInCar = 0;

        for (int location = 0; location < diff.length; location++) {
            passengersInCar += diff[location];

            if (passengersInCar > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {
                {2, 1, 5},
                {3, 3, 7}
        };
        int capacity = 4;

        System.out.println(carPooling(trips, capacity));
        // Output: false
    }
}

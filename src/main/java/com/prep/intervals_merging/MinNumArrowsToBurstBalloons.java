package com.prep.intervals_merging;

import java.util.Arrays;

public class MinNumArrowsToBurstBalloons {

    public static int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort balloons by ending coordinate
        Arrays.sort(points,
                (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        // Shoot the first arrow at the first balloon's end.
        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {

            // Current balloon starts after the last arrow
            if (points[i][0] > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args){
        int[][] points = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        System.out.println(findMinArrowShots(points));

    }
}

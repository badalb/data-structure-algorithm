package com.prep.intervals_merging;

import java.util.Arrays;

public class MeetingRoomsRequired {

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int maxRooms = 0;
        int s = 0, e = 0;

        while (s < n) {
            if (starts[s] < ends[e]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                s++;
            } else {
                rooms--;
                e++;
            }
        }

        return maxRooms;
    }

    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(meetings));
    }
}

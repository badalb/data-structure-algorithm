package com.prep.intervals_merging;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFreeTime {

    public static List<Interval> employeeFreeTime(
            List<List<Interval>> schedule) {

        List<Interval> intervals = new ArrayList<>();

        // 1. Flatten all employee schedules
        for (List<Interval> employee : schedule) {
            intervals.addAll(employee);
        }

        // 2. Sort by start time
        intervals.sort(
                (a, b) -> Integer.compare(a.start, b.start)
        );

        List<Interval> freeTime = new ArrayList<>();

        // 3. Track the end of the combined busy interval
        int currentEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if (next.start > currentEnd) {
                // 4. Found a gap when everyone is free
                freeTime.add(
                        new Interval(currentEnd, next.start)
                );

                currentEnd = next.end;
            } else {
                // Busy intervals overlap
                currentEnd = Math.max(currentEnd, next.end);
            }
        }

        return freeTime;
    }


    static class Interval {
        int start;
        int end;

        Interval() {
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {


        List<List<Interval>> schedule = Arrays.asList(
                // Employee 1
                Arrays.asList(
                        new Interval(1, 3),
                        new Interval(6, 7)
                ),

                // Employee 2
                Arrays.asList(
                        new Interval(2, 4)
                ),

                // Employee 3
                Arrays.asList(
                        new Interval(2, 5),
                        new Interval(9, 12)
                )
        );

        List<Interval> result = employeeFreeTime(schedule);

        result.forEach(a -> System.out.println(a.start + "-" + a.end));
    }

}

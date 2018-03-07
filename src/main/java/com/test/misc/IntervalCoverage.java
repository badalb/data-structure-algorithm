package com.test.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IntervalCoverage {

	public static void main(String[] args) {
		Interval interval1 = new Interval(1, 4);
		Interval interval2 = new Interval(2, 7);
		Interval interval3 = new Interval(3, 6);
		Interval interval4 = new Interval(8, 10);
		Interval interval5 = new Interval(15, 18);
		List<Interval> intervals = new LinkedList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);

		Stack<Interval> mergedIntervals = mergeInterval(intervals);
		for (Interval interval : mergedIntervals) {
			System.out.println("{" + interval.getStart() + "," + interval.getEnd() + "}");
		}
	}

	public static Stack<Interval> mergeInterval(List<Interval> intervals) {
		Stack<Interval> mergedIntervals = new Stack<>();
		mergedIntervals.push(intervals.get(0));

		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			Interval top = mergedIntervals.peek();

			if (top.getEnd() > interval.getStart()) {
				if (top.getEnd() < interval.getEnd()) {
					top.setEnd(interval.getEnd());
				}
			} else {
				mergedIntervals.push(interval);
			}
		}

		return mergedIntervals;
	}

	public static class Interval {
		private int start;
		private int end;

		public Interval() {

		}

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

	}
}

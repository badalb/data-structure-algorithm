package com.test.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumNumberOfPlatform {

	static class TrainTimeTable {
		private int arrival;
		private int departure;

		public TrainTimeTable(int arrival, int departure) {
			this.arrival = arrival;
			this.departure = departure;
		}

		public int getArrival() {
			return arrival;
		}

		public void setArrival(int arrival) {
			this.arrival = arrival;
		}

		public int getDeparture() {
			return departure;
		}

		public void setDeparture(int departure) {
			this.departure = departure;
		}
	}

	public static void main(String[] args) {
		TrainTimeTable t1 = new TrainTimeTable(9, 10);
		TrainTimeTable t2 = new TrainTimeTable(11, 15);
		TrainTimeTable t3 = new TrainTimeTable(12, 13);
		TrainTimeTable t4 = new TrainTimeTable(13, 14);
		TrainTimeTable t5 = new TrainTimeTable(16, 18);
		TrainTimeTable t6 = new TrainTimeTable(17, 19);
		TrainTimeTable t7 = new TrainTimeTable(18, 19);

		List<TrainTimeTable> schedule = new ArrayList<>();
		schedule.add(t1);
		schedule.add(t2);
		schedule.add(t3);
		schedule.add(t4);
		schedule.add(t5);
		schedule.add(t6);
		schedule.add(t7);

		System.out.println("Maximum platform required :" + calculateMaximumStationRequired(schedule));
	}

	private static int calculateMaximumStationRequired(List<TrainTimeTable> schedule) {

		int[] arrival = new int[schedule.size()];
		int[] departure = new int[schedule.size()];

		for (int i = 0; i < schedule.size(); i++) {
			arrival[i] = schedule.get(i).getArrival();
			departure[i] = schedule.get(i).getDeparture();
		}

		Arrays.sort(arrival);
		Arrays.sort(departure);
		int trainAtStattion = 0;
		int maxPlatforms = 0;

		int i = 0;
		int j = 0;
		while (i < arrival.length && j < departure.length) {
			if (arrival[i] < departure[j]) {
				trainAtStattion++;
				i++;
				if (trainAtStattion > maxPlatforms) {
					maxPlatforms = trainAtStattion;
				}
			} else {
				trainAtStattion--;
				j++;
			}
		}
		return maxPlatforms;
	}
}

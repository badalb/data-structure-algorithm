package com.test.recursion;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobSchedulingAlgorithm {

	public static class Job {
		int jobStartTime;
		int jobEndTime;
		int proffit;

		public Job(int jobStartTime, int jobEndTime, int proffit) {
			super();
			this.jobStartTime = jobStartTime;
			this.jobEndTime = jobEndTime;
			this.proffit = proffit;
		}

		public int getJobStartTime() {
			return jobStartTime;
		}

		public void setJobStartTime(int jobStartTime) {
			this.jobStartTime = jobStartTime;
		}

		public int getJobEndTime() {
			return jobEndTime;
		}

		public void setJobEndTime(int jobEndTime) {
			this.jobEndTime = jobEndTime;
		}

		public int getProffit() {
			return proffit;
		}

		public void setProffit(int proffit) {
			this.proffit = proffit;
		}
	}

	static int latestNonConflict(Job arr[], int i) {
		for (int j = i - 1; j >= 0; j--) {
			if (arr[j].getJobEndTime() <= arr[i - 1].getJobStartTime())
				return j;
		}
		return -1;
	}

	private static int getMaxProffit(Job[] jobs, int n) {

		if (jobs == null || jobs.length == 0) {
			return 0;
		}

		if (n == 1) {
			return jobs[n - 1].getProffit();
		}

		int inclProffit = jobs[n - 1].getProffit();

		int k = latestNonConflict(jobs, n);
		if (k != -1) {
			inclProffit += getMaxProffit(jobs, k + 1);
		}

		int exclProf = getMaxProffit(jobs, n - 1);

		return Math.max(inclProffit, exclProf);

	}

	public static void main(String[] args) {
		Job allJobs[] = { new Job(1, 2, 50), new Job(3, 5, 20), new Job(6, 19, 100), new Job(2, 100, 200) };

		Comparator<Job> jobComparator = Comparator.comparingInt(Job::getJobEndTime);
		Arrays.sort(allJobs, jobComparator);
		
		System.out.println("Max proffit: " + getMaxProffit(allJobs, allJobs.length));
	}

}

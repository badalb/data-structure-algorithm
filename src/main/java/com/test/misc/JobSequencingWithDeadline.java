package com.test.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencingWithDeadline {
	
	public static class Job{
		String jobId;
		int deadline;
		int profit;
		public Job(String jobId, int deadline, int profit) {
			super();
			this.jobId = jobId;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	private static void jobSequence(List<Job> jobs, int maxtime){
		
		String[] result = new String[maxtime];
		boolean[] status = new boolean[maxtime];
		int n = jobs.size();
		
		for (int i = 0; i < n; i++) {

            for (int j
                 = Math.min(maxtime - 1, jobs.get(i).deadline - 1);
                 j >= 0; j--) {
                if (status[j] == false)
                {
                	status[j] = true;
                    result[j] = jobs.get(i).jobId;
                    break;
                }
            }
        }
		
		for(String s: result){
			if(s != null){
				System.out.println(s);
			}
		}
		result = null;
		status = null;
	}
	
	
	public static void main(String[] args) {
		
		List<Job> jobs = new ArrayList<Job>();
		 
        jobs.add(new Job("a", 2, 100));
        jobs.add(new Job("b", 1, 19));
        jobs.add(new Job("c", 2, 27));
        jobs.add(new Job("d", 1, 25));
        jobs.add(new Job("e", 3, 15));
        
        Collections.sort(jobs,(a, b) -> b.profit - a.profit);
        jobSequence(jobs, 3);
        
        List<Job> jobs1 = new ArrayList<Job>();
        jobs1.add(new Job("a", 4, 20));
        jobs1.add(new Job("b", 1, 20));
        jobs1.add(new Job("c", 1, 40));
        jobs1.add(new Job("d", 1, 10));
        
        Collections.sort(jobs1,(a, b) -> b.profit - a.profit);
        jobSequence(jobs1, 4);
	}
	
	

}

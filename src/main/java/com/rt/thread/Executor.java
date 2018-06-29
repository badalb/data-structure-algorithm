package com.rt.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

	public static void main(String[] args) {

		//ExecutorService executors = Executors.newFixedThreadPool(5);
		//ExecutorService executors = Executors.newSingleThreadExecutor();
		ExecutorService executors = Executors.newCachedThreadPool();



		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker("" + i);
			executors.execute(worker);
		}

		executors.shutdown();
		while (!executors.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}

}

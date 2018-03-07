package com.test.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceMain {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Callable<String> callableTask = () -> {
			// TimeUnit.MILLISECONDS.sleep(30);
			return "Task's execution";
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);

		Future<String> future = executorService.submit(callableTask);
		System.out.println("Task submitted");
		// try {
		// String result = future.get(100, TimeUnit.MILLISECONDS);
		// System.out.println(result);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		if (future.isDone()) {
			try {
				String result = future.get();
				System.out.println(result);
			} catch (Exception e) {

			}
			System.out.println("Done");
			executorService.shutdown();
		}
	}
}

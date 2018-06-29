package com.rt.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutor {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int number = random.nextInt(10);
			FactorialCalculator calc = new FactorialCalculator(number);
			resultList.add(executor.submit(calc));
		}

		for (Future<Integer> future : resultList) {
			try {
				System.out.println(
						"Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		executor.shutdown();
	}

}

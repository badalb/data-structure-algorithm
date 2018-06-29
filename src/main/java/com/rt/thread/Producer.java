package com.rt.thread;

import java.util.List;

public class Producer implements Runnable {

	private List<Integer> sharedQueue;

	public Producer(List<Integer> sQ) {
		sharedQueue = sQ;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void produce(int i) throws InterruptedException {

		while (!sharedQueue.isEmpty()) {
			synchronized (sharedQueue) {
				System.out.println("Shared queue non empty");
				sharedQueue.wait();
			}
		}

		synchronized (sharedQueue) {
			System.out.println("producing :" + i);
			sharedQueue.add(i);
			Thread.sleep(1000);
			sharedQueue.notify();
		}
	}
}

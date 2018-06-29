package com.rt.thread;

import java.util.List;

public class Consumer implements Runnable {

	private List<Integer> sharedQueue;

	public Consumer(List<Integer> sQ) {
		sharedQueue = sQ;
	}

	@Override
	public void run() {
		try {
			consume();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void consume() throws InterruptedException {

		while (true) {

			synchronized (sharedQueue) {
				if (sharedQueue.isEmpty()) {
					System.out.println("Nothing to consume");
					sharedQueue.wait();
				}
			}

			synchronized (sharedQueue) {
				System.out.println("Consumed : " + sharedQueue.get(0));
				sharedQueue.remove(0);
				Thread.sleep(1000);
				sharedQueue.notify();
			}
		}
	}

}

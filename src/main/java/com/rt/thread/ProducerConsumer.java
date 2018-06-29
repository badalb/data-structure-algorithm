package com.rt.thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		List<Integer> sharedQueue = new ArrayList<>();
		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue);
		
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();

	}

}

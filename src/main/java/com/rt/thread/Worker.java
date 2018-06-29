package com.rt.thread;

public class Worker implements Runnable {

	private String message;

	public Worker(String s) {
		this.message = s;
	}

	@Override
	public void run() {
		System.out.println("Current Thread: " + Thread.currentThread().getName() + " Message: " + this.getMessage());
		process();
		System.out.println("End execution of currentthread :" + Thread.currentThread().getName());
	}

	public String getMessage() {
		return this.message;
	}

	public void process() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

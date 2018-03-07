package com.test.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Badal";
		});


		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
			return "Hello " + name;
		});

		System.out.println(greetingFuture.get());
	}

}

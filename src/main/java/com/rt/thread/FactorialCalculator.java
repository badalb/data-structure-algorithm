package com.rt.thread;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer>{
	
	private int number;
	
	 public FactorialCalculator(int n) {
		this.number = n;
	}

	@Override
	public Integer call() throws Exception {
		int result =1;
		if(this.getNumber() ==0 || this.getNumber() ==1){
			result = 1;
		}else{
			for( int i = number; i>1; i--){
				result = result*i;
			}
		}
		System.out.println("Result for number - " + number + " -> " + result);
		return result;
	}

	
	public int getNumber(){
		return this.number;
	}
}

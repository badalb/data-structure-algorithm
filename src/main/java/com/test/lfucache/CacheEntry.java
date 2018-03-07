package com.test.lfucache;

public class CacheEntry<T> {

	private T data;
	private int frequency;

	public CacheEntry() {
	}

	public CacheEntry(T data, int frequency) {
		super();
		this.data = data;
		this.frequency = frequency;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}

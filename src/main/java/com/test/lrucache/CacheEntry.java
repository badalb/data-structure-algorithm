package com.test.lrucache;

public class CacheEntry<K, V> {

	private CacheEntry<K, V> next;
	private CacheEntry<K, V> previous;
	private K key;
	private V value;

	public CacheEntry(CacheEntry<K, V> previous, CacheEntry<K, V> next, K key, V value) {
		super();
		this.next = next;
		this.previous = previous;
		this.key = key;
		this.value = value;
	}

	public CacheEntry<K, V> getNext() {
		return next;
	}

	public void setNext(CacheEntry<K, V> next) {
		this.next = next;
	}

	public CacheEntry<K, V> getPrevious() {
		return previous;
	}

	public void setPrevious(CacheEntry<K, V> previous) {
		this.previous = previous;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

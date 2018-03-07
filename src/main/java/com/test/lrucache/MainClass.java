package com.test.lrucache;

public class MainClass {

	public static void main(String[] args) {

		LRUCache<String, String> cache = new LRUCache<>(3);

		cache.putCacheEntry("1", "One");
		cache.putCacheEntry("2", "Two");
		cache.putCacheEntry("3", "Three");

		System.out.println(cache.getCacheEntry("1"));
		System.out.println(cache.getCacheEntry("2"));

		cache.putCacheEntry("4", "Four");
		System.out.println(cache.getCacheEntry("3"));
		System.out.println(cache.getCacheEntry("4"));
	}

}

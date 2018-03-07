package com.test.lfucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache<K, V> {

	private int maxSize = 10;
	private Map<K, CacheEntry<V>> cacheMap;

	public LFUCache(int maxSize) {
		this.maxSize = maxSize;
		cacheMap = new LinkedHashMap<>();
	}

	public void putCacheEntry(K key, V value) {
		if (isFull()) {
			K cacheKey = evictCache();
			cacheMap.remove(cacheKey);
		}
		CacheEntry<V> entry = new CacheEntry<>();
		entry.setData(value);
		entry.setFrequency(0);
		cacheMap.put(key, entry);
	}

	public V getCacheEntry(K key) {
		if (cacheMap.containsKey(key)) {
			CacheEntry<V> temp = cacheMap.get(key);
			temp.setFrequency(temp.getFrequency() + 1);
			cacheMap.put(key, temp);
			return temp.getData();
		}
		return null;
	}

	private boolean isFull() {
		return cacheMap.size() == maxSize ? true : false;
	}

	private K evictCache() {
		int minFrequency = Integer.MAX_VALUE;
		K key = null;
		for (Map.Entry<K, CacheEntry<V>> entry : cacheMap.entrySet()) {
			if (entry.getValue().getFrequency() < minFrequency) {
				key = entry.getKey();
			}
		}
		return key;
	}
}

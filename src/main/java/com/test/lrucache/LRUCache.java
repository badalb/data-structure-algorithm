package com.test.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private int maxSize;
	private Map<K, CacheEntry<K, V>> listPointerMap;
	private CacheEntry<K, V> lruEntry;
	private CacheEntry<K, V> mruEntry;

	public LRUCache(int maxSize) {
		this.maxSize = maxSize;
		listPointerMap = new LinkedHashMap<>();
		// least recently used entry is null
		lruEntry = null;
		// most recently used entry is also null
		mruEntry = lruEntry;
	}

	public void putCacheEntry(K key, V value) {

		if (isFull()) {
			// remove from map the left most node
			listPointerMap.remove(lruEntry.getKey());
			// remove the leftmost node
			lruEntry = lruEntry.getNext();
			lruEntry.setPrevious(null);
		}

		CacheEntry<K, V> newEntry = new CacheEntry<K, V>(mruEntry, null, key, value);
		if (mruEntry != null) {
			mruEntry.setNext(newEntry);
		}
		if (lruEntry == null) {
			lruEntry = mruEntry;
		}
		mruEntry = newEntry;
		listPointerMap.put(key, newEntry);
	}

	public V getCacheEntry(K key) {

		CacheEntry<K, V> entry = listPointerMap.get(key);
		// no entry found
		if (entry == null) {
			return null;
		}

		// last or most recently used entry so do nothing
		if (entry.getKey() == mruEntry.getKey()) {
			return entry.getValue();
		}

		CacheEntry<K, V> nextEntry = entry.getNext();
		CacheEntry<K, V> previousEntry = entry.getPrevious();

		// first or least recently used entry
		if (entry.getKey() == lruEntry.getKey()) {
			nextEntry.setPrevious(null);
			lruEntry = nextEntry;
		}

		// somewhere in between
		else if (entry.getKey() != mruEntry.getKey()) {
			previousEntry.setNext(nextEntry);
			nextEntry.setPrevious(previousEntry);
			;
		}

		// Finally move our item to the MRU
		entry.setPrevious(mruEntry);
		mruEntry.setNext(entry);
		mruEntry = entry;
		mruEntry.setNext(null);

		return entry.getValue();
	}

	private boolean isFull() {
		return listPointerMap.size() == maxSize ? true : false;
	}

}

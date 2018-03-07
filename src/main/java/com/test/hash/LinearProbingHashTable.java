package com.test.hash;

public class LinearProbingHashTable {

	private int currentSize;
	private int maxSize;
	private Entry[] hash;

	public LinearProbingHashTable(int size) {
		this.maxSize = size;
		hash = new Entry[size];
		currentSize = 0;
	}

	public void put(String key, String value) {
		Entry entry = new Entry(key, value);
		int index = hash(key);
		int tmp = index;
		do {
			if (hash[index] == null) {
				hash[index] = entry;
				currentSize++;
				return;
			}
			if (hash[index].getKey().equals(key)) {
				hash[index] = entry;
				return;
			}
			index = (index + 1) % maxSize;
		} while (index != tmp);
	}

	public String get(String key) {
		int index = hash(key);
		while (hash[index].getKey() != null) {
			if (hash[index].getKey().equals(key)) {
				return hash[index].getValue();
			}
			index = (index + 1) % maxSize;
		}
		return null;
	}

	public int getSize() {
		return currentSize;
	}

	private int hash(String key) {
		int hash = 7;
		for (int i = 0; i < key.length(); i++) {
			hash = hash * 31 + key.charAt(i);
		}
		return hash % maxSize;
	}

	class Entry {
		private String key;
		private String value;

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

}

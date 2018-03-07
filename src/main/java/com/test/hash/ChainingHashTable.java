package com.test.hash;

import java.util.LinkedList;

public class ChainingHashTable {

	private int MAX_SIZE;
	private LinkedList<Entry>[] hash;

	public ChainingHashTable(int size) {
		this.MAX_SIZE = size;
		hash = new LinkedList[MAX_SIZE];
	}

	public void put(String key, String value) {
		int index = hash(key);
		LinkedList<Entry> items = hash[index];
		if (items != null) {
			for (Entry item : items) {
				if (item.getKey().equals(key)) {
					item.setKey(value);
					return;
				}
			}
			Entry entry = new Entry(key, value);
			LinkedList<Entry> list = new LinkedList<>();
			list.add(entry);
			hash[index] = list;
		} else {
			Entry entry = new Entry(key, value);
			LinkedList<Entry> list = new LinkedList<>();
			list.add(entry);
			hash[index] = list;
		}
	}

	public String get(String key) {
		int index = hash(key);
		LinkedList<Entry> items = hash[index];
		if (items != null) {
			for (Entry item : items) {
				if (item.getKey().equals(key)) {
					return item.getValue();
				}
			}
		}
		return null;
	}

	private int hash(String key) {
		int hash = 7;
		for (int i = 0; i < key.length(); i++) {
			hash = hash * 31 + key.charAt(i);
		}
		return hash % MAX_SIZE;
	}

	class Entry {

		private String key;
		private String value;

		public Entry() {

		}

		public Entry(String key, String value) {
			super();
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

package com.test.hash;

public class ChainingMain {

	public static void main(String[] args) {
		ChainingHashTable hashTable = new ChainingHashTable(10);
		hashTable.put("a", "a");
		hashTable.put("b", "b");
		System.out.println(hashTable.get("b"));
	}

}

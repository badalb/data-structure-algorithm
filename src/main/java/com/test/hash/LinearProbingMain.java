package com.test.hash;

public class LinearProbingMain {

	public static void main(String[] args) {
		LinearProbingHashTable hashTable = new LinearProbingHashTable(10);
		hashTable.put("a", "a");
		hashTable.put("b", "b");

		System.out.println("Get value for key a:" + hashTable.get("a"));
	}

}

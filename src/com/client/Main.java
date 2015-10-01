package com.client;

import com.bst.AvlTree;

public class Main {

	public static void main(String[] args) {
		// Here you can create an AVL tree. This is client code
		final int nodeCount = 50000000;
		final int duplicateKey = nodeCount - 1;
		
		startInsert(nodeCount, duplicateKey);
		startInsertIter(nodeCount, duplicateKey);
	}
	
	private static void startInsert(int nodeCount, int duplicateKey) {
		long start = System.currentTimeMillis();
		AvlTree avlTree = new AvlTree();
		
		for (int i = 0; i < nodeCount; i++) {
			avlTree.insert(i);
		}
		
		for (int i = 0; i < 100000; i++) {
			avlTree.insert(duplicateKey);
		}
		
		double time = (System.currentTimeMillis() - start) / 1000.0;
		System.out.println("time = " + time);
	}
	
	private static void startInsertIter(int nodeCount, int duplicateKey) {
		long startIter = System.currentTimeMillis();
		AvlTree avlTreeIter = new AvlTree();
		
		for (int i = 0; i < nodeCount; i++) {
			avlTreeIter.insertIteratively(i);
		}
		
		for (int i = 0; i < 100000; i++) {
			avlTreeIter.insertIteratively(duplicateKey);
		}

		double timeIter = (System.currentTimeMillis() - startIter) / 1000.0;
		System.out.println("timeIter = " + timeIter);
	}
}

package com.client;

import com.bst.AvlTree;

public class Main {
 
	public static void main(String[] args) {
		// Client code goes here
		final int start = 0;
		final int count = 10000000; 
		AvlTree<Integer> avlTree1 = fillTree(start, count);
		AvlTree<Integer> avlTree2 = fillTree(count, 2 * count);
		long startTimeStamp = System.currentTimeMillis();
		System.out.println(avlTree1.equals(avlTree2));
		printDuration("equals: ", startTimeStamp, System.currentTimeMillis());
	}
	
	private static AvlTree<Integer> fillTree(int start, int count) {
		AvlTree<Integer> avlTree = new AvlTree<Integer>();
		long startTimeStamp = System.currentTimeMillis();
		for (int i = start; i < start + count; i++) {
			avlTree.insert(i);
		}
		printDuration("Insertion: ", startTimeStamp, System.currentTimeMillis());
		return avlTree;
	}
	
	private static void printDuration(String operation, long start, long end) {
		System.out.println(operation + (end - start) / 1000.0);
	}
}

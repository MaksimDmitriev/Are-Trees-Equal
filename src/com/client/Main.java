package com.client;

import com.bst.AvlTree;

public class Main {

	public static void main(String[] args) {
		A m1 = new A(12);
		A m2 = new A(null);
		System.out.println("Int and Int: " + m1.compareTo(m2));
		
		
		/*
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
		*/
	}
	
	static class A implements Comparable<A> {
		int x;
		
		public A(int x) {
			this.x = x;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof A)) {
				return false;
			}
			A other = (A) obj;
			return x == other.x;
		}
		
		@Override
		public int compareTo(A o) {
			if (this == o) {
				return 0;
			}
			return x - o.x;
		}
		
	}
	
	static class B {
		int y;
		
		public B(int y) {
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof B)) {
				return false;
			}
			B other = (B) obj;
			return y == other.y;
		}
	}
	
	static class MyClass<T> implements Comparable<MyClass<T>> {
		
		T key;
		
		public MyClass(T key) {
			this.key = key;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			MyClass other = (MyClass) obj;
			// Handles nulls, a null key, and then contents 
			return key == other.key || (key == null ? false : key.equals(other.key));
		}

		@Override
		public int compareTo(MyClass<T> o) {
			if (this == o) {
				return 0;
			}
			return key.
		}
	}
}

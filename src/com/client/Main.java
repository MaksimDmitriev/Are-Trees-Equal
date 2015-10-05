package com.client;

import com.bst.AvlTree;

public class Main {

	public static void main(String[] args) {
//		Object object = new MyClass<Integer>(new Integer(12));
//		System.out.println(object instanceof MyClass);
		
		MyClass<Integer> m1 = new MyClass<Integer>(12);
		MyClass<Integer> m2 = new MyClass<Integer>(12);
//		System.out.println("Int and Int: " + m1.equals(m2));
		
		MyClass<Double> m3 = new MyClass<Double>(12.5);
//		System.out.println("Int and Dounle: " + m1.equals(m3));
		
		
		MyClass<A> m4 = new MyClass<A>(new A(12));
		MyClass<B> m5 = new MyClass<B>(new B(34));
		System.out.println(m4.equals(m5));
		
//		System.out.println(m1.key.getClass());
//		System.out.println(m2.key.getClass());
		
		
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
	
	static class A {
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
	
	static class MyClass<T> {
		
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
	}
}

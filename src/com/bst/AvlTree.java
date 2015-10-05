package com.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AvlTree<T extends Comparable<T>> {

    Node<T> root;

    public AvlTree() {
    }

	public AvlTree(T... keys) {
		if (keys != null) {
			insert(keys);
		}
	}
	
	public void insertIteratively(T... keys) {
		if (keys != null) {
			for (T key : keys) {
				insertIteratively(root, key);
			}
		}
	}

    private Node<T> insert(Node<T> parent, T key) {
        if (parent == null) {
            return new Node<T>(key);
        }
        if (key.compareTo(parent.key) < 0) {
            parent.left = insert(parent.left, key);
        } else if (key.compareTo(parent.key) > 0) {
            parent.right = insert(parent.right, key);
        }
        return balance(parent);
    }
    
    private void insertIteratively(Node<T> parent, T key) {    	
        if (parent == null) {
            root = new Node<T>(key);
            return;
        }
        // current.key
        Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
        Node<T> current = parent;
        while (current != null) {
        	parent = current;
        	stack.push(current);
        	if (key.compareTo(current.key) == 0) {
        		return;
        	}
        	current = key.compareTo(current.key) < 0 ? current.left : current.right;
        }
        Node<T> inserted = new Node<T>(key);
        if (key.compareTo(parent.key) < 0) {
        	parent.left = inserted;
        } else {
        	parent.right = inserted;
        }
        balance(inserted, stack);
    }
    
    private void balance(Node<T> inserted, Deque<Node<T>> stack) {
    	Node<T> newLocalRoot = inserted;
        while (!stack.isEmpty()) {
    		Node<T> current = stack.pop();
    		if (newLocalRoot.compareTo(current.key) < 0) {
    			current.left = newLocalRoot;
    		} else {
    			current.right = newLocalRoot;
    		}
    		newLocalRoot = balance(current); 
        }
        root = newLocalRoot;
    }

    private Node<T> balance(Node<T> p) {
        fixHeight(p);
        if (bfactor(p) == 2) {
            if (bfactor(p.right) < 0) {
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if (bfactor(p) == -2) {
            if (bfactor(p.left) > 0) {
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
    }
    
    private Node<T> rotateRight(Node<T> p) {
        Node<T> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }
    
    private Node<T> rotateLeft(Node<T> q) {
        Node<T> p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    private int height(Node<T> p) {
        return p == null ? 0 : p.height;
    }
    
    private int bfactor(Node<T> p) {
        return height(p.right) - height(p.left);
    }

    private void fixHeight(Node<T> p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (hl > hr ? hl : hr) + 1;
    }

    public void insert(T... keys) {
        for (T key : keys) {
            root = insert(root, key);
        }
    }
    
    public void insert(T key) {
    	root = insert(root, key);
    }

    public void insertIteratively(T key) {
    	insertIteratively(root, key);
    }

    @Override
    public boolean equals(Object arg0) {
        if (this == arg0) {
            return true;
        }
        if (!(arg0 instanceof AvlTree)) {
            return false;
        }
        AvlTree other = (AvlTree) arg0;
        return areTreesEqual(this.root, other.root);
    }

    private boolean areTreesEqual(Node<T> root1, Node<T> root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.key == root2.key && areTreesEqual(root1.left, root2.left) && areTreesEqual(root1.right, root2.right);
    }

    @Override
    public int hashCode() {
        if (root == null) {
            return 0;
        }
        Queue<Node<T>> nodes = new LinkedList<Node<T>>();
        nodes.add(root);
        int res = 17;
        while (!nodes.isEmpty()) {
            Node<T> head = nodes.remove();
            res = 31 * res + head.hashCode();
            if (head.left != null) {
                nodes.add(head.left);
            }
            if (head.right != null) {
                nodes.add(head.right);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        inOrderPrint(root, builder);
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }

    private void inOrderPrint(Node<T> root, StringBuilder builder) {
        if (root != null) {
            inOrderPrint(root.left, builder);
            builder.append(root + ", ");
            inOrderPrint(root.right, builder);
        }
    }

    static class Node<T> implements Comparable<Node<T>> {

        Node<T> left;
        Node<T> right;
        final T key;
        private int height;

        private Node(T key) {
            this.key = key;
            this.height = 1;
        }

        @Override
        public int hashCode() {
        	return key == null ? 0 : key.hashCode();
        }
        
        @Override
        public boolean equals(Object obj) {
        	if (obj == this) {
        		return true;
        	}
        	if (!(obj instanceof Node)) {
        		return false;
        	}
        	Node other = (Node) obj;
			// Handles nulls, a null this.key, and then check if this and other are
        	// logically equal
        	return key == other.key || (key == null ? false : key.equals(other.key)); 
        }

        @Override
        public String toString() {
            return key == null ? "" : key.toString();
        }
        
        @Override
        public int compareTo(Node<T> o) {
        	if (this == o) {
        		return 0;
        	}
        	// TODO Auto-generated method stub
        	return 0;
        }
    }

}

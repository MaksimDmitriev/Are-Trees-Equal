package com.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AvlTree {

    Node root;

    public AvlTree() {

    }

	public AvlTree(int... keys) {
		insert(keys);
	}
	
	public void insertRecursively(int... keys) {
		if (keys != null) {
			for (int key : keys) {
				insertRecursively(root, key);
			}
		}
	}

    private Node insert(Node parent, int key) {
        if (parent == null) {
            return new Node(key);
        }
        if (key < parent.key) {
            parent.left = insert(parent.left, key);
        } else if (key > parent.key) {
            parent.right = insert(parent.right, key);
        }
        return balance(parent);
    }
    
    private void insertRecursively(Node parent, int key) {    	
        if (parent == null) {
            root = new Node(key);
            return;
        }
        Deque<Node> stack = new ArrayDeque<Node>();
        Node current = parent;
        while (current != null) {
        	parent = current;
        	stack.push(current);
        	if (key == current.key) {
        		return;
        	}
        	current = key < current.key ? current.left : current.right;
        }
        if (key < parent.key) {
        	parent.left = new Node(key);
        } else {
        	parent.right = new Node(key);
        }
        balance(stack);
    }
    
    private void balance(Deque<Node> stack) {
        while (!stack.isEmpty()) {
        	Node lastStackElement = stack.pop();
        	Node newLocalRoot = balance(lastStackElement);
        	if (!newLocalRoot.equals(lastStackElement) && !stack.isEmpty()) {
        		lastStackElement = stack.pop();
        		if (newLocalRoot.key < lastStackElement.key) {
        			lastStackElement.left = newLocalRoot;
        		} else {
        			lastStackElement.right = newLocalRoot;
        		}
        	}
        }
    }

    private Node balance(Node p) {
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
    
    private Node rotateRight(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }
    
    private Node rotateLeft(Node q) {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    private int height(Node p) {
        return p == null ? 0 : p.height;
    }
    
    private int bfactor(Node p) {
        return height(p.right) - height(p.left);
    }

    private void fixHeight(Node p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (hl > hr ? hl : hr) + 1;
    }

    public void insert(int... keys) {
        for (int value : keys) {
            root = insert(root, value);
        }
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

    private boolean areTreesEqual(Node root1, Node root2) {
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
        Queue<Node> nodes = new LinkedList<AvlTree.Node>();
        nodes.add(root);
        int res = 17;
        while (!nodes.isEmpty()) {
            Node head = nodes.remove();
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

    private void inOrderPrint(Node root, StringBuilder builder) {
        if (root != null) {
            inOrderPrint(root.left, builder);
            builder.append(root + ", ");
            inOrderPrint(root.right, builder);
        }
    }

    static class Node {

        Node left;
        Node right;
        final int key;
        private int height;

        private Node(int key) {
            this.key = key;
            this.height = 1;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = 17 * res + key;
            return res;
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
        	return key == other.key;
        }

        @Override
        public String toString() {
            return Integer.toString(key);
        }
    }

}

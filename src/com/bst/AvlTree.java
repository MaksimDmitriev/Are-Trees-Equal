package com.bst;

import java.util.LinkedList;
import java.util.Queue;

public class AvlTree<T extends Comparable<T>> {

    Node<T> root;

    public AvlTree() {
    }

	public AvlTree(T... keys) {
		insert(keys);
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
		if (keys == null) {
			return;
		}
        for (T key : keys) {
        	if (key == null) {
        		continue;
        	}
            root = insert(root, key);
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

    /**
     * 
     * @param root1 the root of the first tree
     * @param root2 the root of the second tree
     * @return true if the trees with the given roots are structurally identical, 
     * false otherwise
     */
    private boolean areTreesEqual(Node<T> root1, Node<T> root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.equals(root2) && areTreesEqual(root1.left, root2.left) && areTreesEqual(root1.right, root2.right);
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

    static class Node<T> {

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
        	return key.equals(other.key); 
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }

}

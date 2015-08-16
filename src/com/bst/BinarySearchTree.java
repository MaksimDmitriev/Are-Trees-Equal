package com.bst;

import java.util.LinkedList;

public class BinarySearchTree {

    private Node mRoot;

    public BinarySearchTree() {

    }

    public BinarySearchTree(int... values) {
        if (values == null) {
            return;
        }
        if (values.length == 0) {
            throw new IllegalArgumentException("The array is null or empty");
        }
        insert(values);
    }
    
    // http://habrahabr.ru/post/150732/
    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.mValue) {
            root.mLeft = insert(root.mLeft, value);
        } else {
            root.mRight = insert(root.mRight, value);
        }
        return balance(root);
    }

    
    private Node balance(Node node) {
        // TODO: 
        return node;
    }

    public void insert(int... values) {
        for (int value : values) {

        }
    }

    @Override
    public boolean equals(Object arg0) {
        if (this == arg0) {
            return true;
        }
        if (!(arg0 instanceof BinarySearchTree)) {
            return false;
        }
        BinarySearchTree another = (BinarySearchTree) arg0;
        return areTreesEqual(this.mRoot, another.mRoot);
    }

    private boolean areTreesEqual(Node root1, Node root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.mValue == root2.mValue && areTreesEqual(root1.mLeft, root2.mLeft) && areTreesEqual(root1.mRight, root2.mRight);
    }

    @Override
    public int hashCode() {
        if (mRoot == null) {
            return 0;
        }
        LinkedList<Node> nodes = new LinkedList<BinarySearchTree.Node>();
        nodes.add(mRoot);
        int res = 17;
        while (!nodes.isEmpty()) {
            Node head = nodes.remove();
            res = 31 * res + head.hashCode();
            if (head.mLeft != null) {
                nodes.addLast(head.mLeft);
            }
            if (head.mRight != null) {
                nodes.addLast(head.mRight);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        if (mRoot == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        inOrderPrint(mRoot, builder);
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }

    private void inOrderPrint(Node root, StringBuilder builder) {
        if (root != null) {
            inOrderPrint(root.mLeft, builder);
            builder.append(root + ", ");
            inOrderPrint(root.mRight, builder);
        }
    }

    private static class Node {

        private Node mLeft;
        private Node mRight;
        private final int mValue;
        private int mHeight;

        private Node(int value) {
            mValue = value;
            mHeight = 1;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = 17 * res + mValue;
            return res;
        }

        @Override
        public String toString() {
            return Integer.toString(mValue);
        }
    }

}

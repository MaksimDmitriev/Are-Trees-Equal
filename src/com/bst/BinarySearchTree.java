package com.bst;

public class BinarySearchTree {

    private Node mRoot;

    public BinarySearchTree() {

    }

    public BinarySearchTree(int... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("The array is null or empty");
        }
        insert(values);
    }

    public void insert(int... values) {
        for (int value : values) {
            Node current = mRoot;
            Node parent = null;
            while (current != null) {
                parent = current;
                if (value < current.mValue) {
                    current = current.mLeft;
                } else {
                    current = current.mRight;
                }
            }
            // The tree was empty.
            if (parent == null) {
                mRoot = new Node(value);
            } else if (value < parent.mValue) {
                parent.mLeft = new Node(value);
            } else {
                parent.mRight = new Node(value);
            }
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
        int result = 17;
        result = 31 * result + sumElements(mRoot);
        return result;
    }

    private int sumElements(Node root) {
        if (root == null) {
            return 0;
        }
        return root.mValue + sumElements(root.mLeft) + sumElements(root.mRight);
    }

    @Override
    public String toString() {
        if (mRoot == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        inOrder(mRoot, builder);
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }

    private void inOrder(Node root, StringBuilder builder) {
        if (root != null) {
            inOrder(root.mLeft, builder);
            builder.append(root + ", ");
            inOrder(root.mRight, builder);
        }
    }

    private class Node {

        private Node mLeft;
        private Node mRight;
        private final int mValue;

        private Node(int value) {
            this.mValue = value;
        }

        @Override
        public String toString() {
            return Integer.toString(mValue);
        }
    }

}

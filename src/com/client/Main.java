package com.client;

import com.bst.AvlTree;

public class Main {

    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree(10);
        avlTree.insert(18);
        avlTree.insert(12);

    }
//    public interface Hashable
//    {
//
//        /**
//         * Compute a hash function for this object.
//         * 
//         * @param tableSize the hash table size.
//         * @return (deterministically) a number between
//         * 0 and tableSize-1, distributed equitably.
//         */
//        int hash(int tableSize);
//    }
//
//    public static final class MyInteger implements Comparable, Hashable
//    {
//
//        /**
//         * Construct the MyInteger object with initial value 0.
//         */
//        public MyInteger()
//        {
//            this(0);
//        }
//
//        /**
//         * Construct the MyInteger object.
//         * 
//         * @param x the initial value.
//         */
//        public MyInteger(int x)
//        {
//            value = x;
//        }
//
//        /**
//         * Gets the stored int value.
//         * 
//         * @return the stored value.
//         */
//        public int intValue()
//        {
//            return value;
//        }
//
//        /**
//         * Implements the toString method.
//         * 
//         * @return the String representation.
//         */
//        public String toString()
//        {
//            return Integer.toString(value);
//        }
//
//        /**
//         * Implements the equals method.
//         * 
//         * @param rhs the second MyInteger.
//         * @return true if the objects are equal, false otherwise.
//         * @exception ClassCastException if rhs is not
//         * a MyInteger.
//         */
//        public boolean equals(Object rhs)
//        {
//            return rhs != null && value == ((MyInteger) rhs).value;
//        }
//
//        /**
//         * Implements the hash method.
//         * 
//         * @param tableSize the hash table size.
//         * @return a number between 0 and tableSize-1.
//         */
//        public int hash(int tableSize)
//        {
//            if (value < 0) return -value % tableSize;
//            else return value % tableSize;
//        }
//
//        private int value;
//
//        @Override
//        public int compareTo(Object arg0) {
//
//            return value < ((MyInteger) arg0).value ? -1 :
//                    value == ((MyInteger) arg0).value ? 0 : 1;
//
//        }
//    }
//
//    // Basic node stored in AVL trees
//    // Note that this class is not accessible outside
//    // of package DataStructures
//
//    static class AvlNode
//    {
//
//        // Constructors
//        AvlNode(Comparable theElement)
//        {
//            this(theElement, null, null);
//        }
//
//        AvlNode(Comparable theElement, AvlNode lt, AvlNode rt)
//        {
//            element = theElement;
//            left = lt;
//            right = rt;
//            height = 0;
//        }
//
//        // Friendly data; accessible by other package routines
//        Comparable element; // The data in the node
//        AvlNode left; // Left child
//        AvlNode right; // Right child
//        int height; // Height
//    }
//
//    // BinarySearchTree class
//    //
//    // CONSTRUCTION: with no initializer
//    //
//    // ******************PUBLIC OPERATIONS*********************
//    // void insert( x ) --> Insert x
//    // void remove( x ) --> Remove x (unimplemented)
//    // Comparable find( x ) --> Return item that matches x
//    // Comparable findMin( ) --> Return smallest item
//    // Comparable findMax( ) --> Return largest item
//    // boolean isEmpty( ) --> Return true if empty; else false
//    // void makeEmpty( ) --> Remove all items
//    // void printTree( ) --> Print tree in sorted order
//
//    /**
//     * Implements an AVL tree.
//     * Note that all "matching" is based on the compareTo method.
//     * 
//     * @author Mark Allen Weiss
//     */
//    public static class AvlTree
//    {
//
//        /**
//         * Construct the tree.
//         */
//        public AvlTree()
//        {
//            root = null;
//        }
//
//        /**
//         * Insert into the tree; duplicates are ignored.
//         * 
//         * @param x the item to insert.
//         */
//        public void insert(Comparable x)
//        {
//            root = insert(x, root);
//        }
//
//        /**
//         * Remove from the tree. Nothing is done if x is not found.
//         * 
//         * @param x the item to remove.
//         */
//        public void remove(Comparable x)
//        {
//            System.out.println("Sorry, remove unimplemented");
//        }
//
//        /**
//         * Find the smallest item in the tree.
//         * 
//         * @return smallest item or null if empty.
//         */
//        public Comparable findMin()
//        {
//            return elementAt(findMin(root));
//        }
//
//        /**
//         * Find the largest item in the tree.
//         * 
//         * @return the largest item of null if empty.
//         */
//        public Comparable findMax()
//        {
//            return elementAt(findMax(root));
//        }
//
//        /**
//         * Find an item in the tree.
//         * 
//         * @param x the item to search for.
//         * @return the matching item or null if not found.
//         */
//        public Comparable find(Comparable x)
//        {
//            return elementAt(find(x, root));
//        }
//
//        /**
//         * Make the tree logically empty.
//         */
//        public void makeEmpty()
//        {
//            root = null;
//        }
//
//        /**
//         * Test if the tree is logically empty.
//         * 
//         * @return true if empty, false otherwise.
//         */
//        public boolean isEmpty()
//        {
//            return root == null;
//        }
//
//        /**
//         * Print the tree contents in sorted order.
//         */
//        public void printTree()
//        {
//            if (isEmpty()) System.out.println("Empty tree");
//            else printTree(root);
//        }
//
//        /**
//         * Internal method to get element field.
//         * 
//         * @param t the node.
//         * @return the element field or null if t is null.
//         */
//        private Comparable elementAt(AvlNode t)
//        {
//            return t == null ? null : t.element;
//        }
//
//        /**
//         * Internal method to insert into a subtree.
//         * 
//         * @param x the item to insert.
//         * @param parent the node that roots the tree.
//         * @return the new root.
//         */
//        private AvlNode insert(Comparable x, AvlNode parent)
//        {
//            if (parent == null) parent = new AvlNode(x, null, null);
//            else if (x.compareTo(parent.element) < 0)
//            {
//                parent.left = insert(x, parent.left);
//                if (height(parent.left) - height(parent.right) == 2) {
//                    if (x.compareTo(parent.left.element) < 0)
//                        parent = rotateWithLeftChild(parent);
//                    else
//                        parent = doubleWithLeftChild(parent);
//                }
//
//            }
//            else if (x.compareTo(parent.element) > 0)
//            {
//                parent.right = insert(x, parent.right);
//                if (height(parent.right) - height(parent.left) == 2)
//                    if (x.compareTo(parent.right.element) > 0)
//                    parent = rotateWithRightChild(parent);
//                    else
//                    parent = doubleWithRightChild(parent);
//            }
//            else
//            ; // Duplicate; do nothing
//            parent.height = max(height(parent.left), height(parent.right)) + 1;
//            return parent;
//        }
//
//        /**
//         * Internal method to find the smallest item in a subtree.
//         * 
//         * @param t the node that roots the tree.
//         * @return node containing the smallest item.
//         */
//        private AvlNode findMin(AvlNode t)
//        {
//            if (t == null)
//                return t;
//
//            while (t.left != null)
//                t = t.left;
//            return t;
//        }
//
//        /**
//         * Internal method to find the largest item in a subtree.
//         * 
//         * @param t the node that roots the tree.
//         * @return node containing the largest item.
//         */
//        private AvlNode findMax(AvlNode t)
//        {
//            if (t == null)
//                return t;
//
//            while (t.right != null)
//                t = t.right;
//            return t;
//        }
//
//        /**
//         * Internal method to find an item in a subtree.
//         * 
//         * @param x is item to search for.
//         * @param t the node that roots the tree.
//         * @return node containing the matched item.
//         */
//        private AvlNode find(Comparable x, AvlNode t)
//        {
//            while (t != null)
//                if (x.compareTo(t.element) < 0) t = t.left;
//                else if (x.compareTo(t.element) > 0) t = t.right;
//                else return t; // Match
//
//            return null; // No match
//        }
//
//        /**
//         * Internal method to print a subtree in sorted order.
//         * 
//         * @param t the node that roots the tree.
//         */
//        private void printTree(AvlNode t)
//        {
//            if (t != null)
//            {
//                printTree(t.left);
//                System.out.println(t.element);
//                printTree(t.right);
//            }
//        }
//
//        /**
//         * Return the height of node t, or -1, if null.
//         */
//        private static int height(AvlNode t)
//        {
//            return t == null ? -1 : t.height;
//        }
//
//        /**
//         * Return maximum of lhs and rhs.
//         */
//        private static int max(int lhs, int rhs)
//        {
//            return lhs > rhs ? lhs : rhs;
//        }
//
//        /**
//         * Rotate binary tree node with left child.
//         * For AVL trees, this is a single rotation for case 1.
//         * Update heights, then return new root.
//         */
//        private static AvlNode rotateWithLeftChild(AvlNode k2)
//        {
//            AvlNode k1 = k2.left;
//            k2.left = k1.right;
//            k1.right = k2;
//            k2.height = max(height(k2.left), height(k2.right)) + 1;
//            k1.height = max(height(k1.left), k2.height) + 1;
//            return k1;
//        }
//
//        /**
//         * Rotate binary tree node with right child.
//         * For AVL trees, this is a single rotation for case 4.
//         * Update heights, then return new root.
//         */
//        private static AvlNode rotateWithRightChild(AvlNode k1)
//        {
//            AvlNode k2 = k1.right;
//            k1.right = k2.left;
//            k2.left = k1;
//            k1.height = max(height(k1.left), height(k1.right)) + 1;
//            k2.height = max(height(k2.right), k1.height) + 1;
//            return k2;
//        }
//
//        /**
//         * Double rotate binary tree node: first left child
//         * with its right child; then node k3 with new left child.
//         * For AVL trees, this is a double rotation for case 2.
//         * Update heights, then return new root.
//         */
//        private static AvlNode doubleWithLeftChild(AvlNode k3)
//        {
//            k3.left = rotateWithRightChild(k3.left);
//            return rotateWithLeftChild(k3);
//        }
//
//        /**
//         * Double rotate binary tree node: first right child
//         * with its left child; then node k1 with new right child.
//         * For AVL trees, this is a double rotation for case 3.
//         * Update heights, then return new root.
//         */
//        private static AvlNode doubleWithRightChild(AvlNode k1)
//        {
//            k1.right = rotateWithLeftChild(k1.right);
//            return rotateWithRightChild(k1);
//        }
//
//        /** The tree root. */
//        private AvlNode root;
//
//    }

}

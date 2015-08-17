package com.bst;

import org.junit.Assert;
import org.junit.Test;

public class AvlTreeTest {
    
    @Test
    public void testDefaultConstructor() {
        AvlTree t1 = new AvlTree();
        Assert.assertNull(t1.mRoot);
    }
    
    @Test
    public void testIntegerConstructor() {
        AvlTree t1 = new AvlTree(1);
        Assert.assertNotNull(t1.mRoot);
    }
    
    @Test
    public void testInsertToEmptyTree() {
        AvlTree t1 = new AvlTree();
        t1.insert(1);
        Assert.assertEquals(1, t1.mRoot.mValue);
    }

    @Test
    public void testEqualsItself() {
        AvlTree t1 = new AvlTree();
        Assert.assertEquals(t1, t1);
    }
    
    @Test
    public void testNotEqualNotAvlInstance() {
        AvlTree t1 = new AvlTree();
        Object object = new Object();
        Assert.assertNotEquals(t1, object);
    }
    
    @Test
    public void testEmptyEqual() {
        AvlTree t1 = new AvlTree();
        AvlTree t2 = new AvlTree();
        Assert.assertEquals(t1, t2);
    }
    
    @Test
    public void testOneEmpty() {
        AvlTree t1 = new AvlTree();
        AvlTree t2 = new AvlTree(1);
        Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testOneEmpty() {
        AvlTree t1 = new AvlTree(1);
        AvlTree t2 = new AvlTree();
        Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testEqualOneNode() {
        AvlTree t1 = new AvlTree(1);
        AvlTree t2 = new AvlTree(1);
        Assert.assertEquals(t1, t2);
    }
//
//    @Test
//    public void testEqualRefs() {
//        BinarySearchTree t1 = new BinarySearchTree();
//        BinarySearchTree t2 = t1;
//        Assert.assertTrue(t1.equals(t2));
//    }
//    
//    @Test
//    public void testEqulas() {
//        BinarySearchTree t1 = new BinarySearchTree(new int[] {1, 2, 3});
//        BinarySearchTree t2 = new BinarySearchTree(new int[] {1, 2, 3});
//        Assert.assertTrue(t1.equals(t2));
//    }

}

package com.bst;

import org.junit.Assert;
import org.junit.Test;

public class AvlTreeTest {
/*
    @Test
    public void testDefaultConstructor() {
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        Assert.assertNull(t1.root);
    }

    @Test
    public void testIntegerConstructor() {
        AvlTree<Integer> t1 = new AvlTree<Integer>(1);
        Assert.assertNotNull(t1.root);
    }

    @Test
    public void testInsertToEmptyTree() {
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        t1.insert(1);
        // uals(1, t1.root.key);
        Assert.assertEquals(1, t1.root.key);
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
    public void testFirstEmpty() {
        AvlTree t1 = new AvlTree();
        AvlTree t2 = new AvlTree(1);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testSecondEmpty() {
        AvlTree t1 = new AvlTree(1);
        AvlTree t2 = new AvlTree();
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testRootsEqual() {
        AvlTree t1 = new AvlTree(1);
        AvlTree t2 = new AvlTree(1);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootAndLeftEqual() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2);
        AvlTree t2 = new AvlTree(10);
        t2.insert(2);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootAndRightEqual() {
        AvlTree t1 = new AvlTree(1);
        t1.insert(2);
        AvlTree t2 = new AvlTree(1);
        t2.insert(2);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootsEqual_LeftsNotEqual() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2);
        AvlTree t2 = new AvlTree(10);
        t2.insert(1);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testRootsEqual_RightsNotEqual() {
        AvlTree t1 = new AvlTree(1);
        t1.insert(2);
        AvlTree t2 = new AvlTree(1);
        t2.insert(4);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testEmptyTreeHashCode() {
        AvlTree t1 = new AvlTree();
        Assert.assertEquals(0, t1.hashCode());
    }

    @Test
    public void testEqualTreesEqualHashCodes() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2, 12);
        AvlTree t2 = new AvlTree(10);
        t2.insert(2, 12);
        Assert.assertEquals(t1.hashCode(), t2.hashCode());
    }
    
    @Test
    public void testToStringEmpty() {
        AvlTree t1 = new AvlTree();
        Assert.assertEquals("[]", t1.toString());
    }
    
    @Test
    public void testToStringSingleNode() {
        AvlTree t1 = new AvlTree(1);
        Assert.assertEquals("[1]", t1.toString());
    }

    @Test
    public void testToStringManyNodes() {
        AvlTree t1 = new AvlTree(1);
        t1.insert(12, 56, 7, 2, 1);
        Assert.assertEquals("[1, 2, 7, 12, 56]", t1.toString());
    }

    @Test
    public void testSingleRotateLeft() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(14, 56);
        Assert.assertEquals(t1.root.key, 14);
        Assert.assertEquals(t1.root.left.key, 10);
        Assert.assertEquals(t1.root.right.key, 56);
    }

    @Test
    public void testSingleRotateRight() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2, 1);
        Assert.assertEquals(t1.root.key, 2);
        Assert.assertEquals(t1.root.left.key, 1);
        Assert.assertEquals(t1.root.right.key, 10);
    }
    
    @Test
    public void testDoubleRotateLeftRight() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(4, 9);
        Assert.assertEquals(t1.root.key, 9);
        Assert.assertEquals(t1.root.left.key, 4);
        Assert.assertEquals(t1.root.right.key, 10);
    }

    @Test
    public void testDoubleRotateRightLeft() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(14, 12);
        Assert.assertEquals(t1.root.key, 12);
        Assert.assertEquals(t1.root.left.key, 10);
        Assert.assertEquals(t1.root.right.key, 14);
    }
    */
}

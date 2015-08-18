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
        Assert.assertEquals("[1, 1, 2, 7, 12, 56]", t1.toString());
    }

    @Test
    public void testSingleRotateLeft() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(14, 56);
        Assert.assertEquals(t1.mRoot.mValue, 14);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 56);
    }

    @Test
    public void testSingleRotateRight() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2, 1);
        Assert.assertEquals(t1.mRoot.mValue, 2);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 1);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 10);
    }
    
    @Test
    public void testDoubleRotateLeftRight() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(4, 9);
        Assert.assertEquals(t1.mRoot.mValue, 9);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 4);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 10);
    }

    @Test
    public void testDoubleRotateRightLeft() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(14, 12);
        Assert.assertEquals(t1.mRoot.mValue, 12);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 14);
    }
}

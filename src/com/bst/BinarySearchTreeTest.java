package com.bst;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testArrayNull() {
        BinarySearchTree t1 = new BinarySearchTree(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayEmpty() {
        BinarySearchTree t1 = new BinarySearchTree(new int[] {});
    }

    @Test
    public void testEqualsItself() {
        BinarySearchTree t1 = new BinarySearchTree();
        Assert.assertTrue(t1.equals(t1));
    }

    @Test
    public void testEqualRefs() {
        BinarySearchTree t1 = new BinarySearchTree();
        BinarySearchTree t2 = t1;
        Assert.assertTrue(t1.equals(t2));
    }

}

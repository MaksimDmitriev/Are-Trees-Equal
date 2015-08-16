package com.bst;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
    
    @Test
    public void testDefaultConstructor() {
        BinarySearchTree t1 = new BinarySearchTree();
        // TODO: Don't rely on the result of toString(). Assert.isTrue(mRoot == null);

        Assert.assertEquals("[]", t1.toString());
    }
//
//    @Test
//    public void testEqualsItself() {
//        BinarySearchTree t1 = new BinarySearchTree();
//        Assert.assertTrue(t1.equals(t1));
//    }
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

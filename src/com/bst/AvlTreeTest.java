package com.bst;

import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import com.bst.AvlTree.Node;

public class AvlTreeTest {

	@Test
    public void testTwoEmptyTrees() {
		AvlTree<Integer> t1 = new AvlTree<Integer>();
		AvlTree<Integer> t2 = new AvlTree<Integer>();
		Assert.assertEquals(t1, t2);
	}
	
	@Test
    public void testLeftEmptyTree() {
		AvlTree<Integer> t1 = new AvlTree<Integer>();
		AvlTree<Integer> t2 = new AvlTree<Integer>(12);
		Assert.assertNotEquals(t1, t2);
	}
	
	@Test
    public void testRightEmptyTree() {
		AvlTree<Integer> t1 = new AvlTree<Integer>(12);
		AvlTree<Integer> t2 = new AvlTree<Integer>();
		Assert.assertNotEquals(t1, t2);
	}
	
    @Test
    public void testEqualsItself() {
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        Assert.assertEquals(t1, t1);
    }
    
    @Test
    public void testNotEqualNotAvlInstance() {
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        Object object = new Object();
        Assert.assertNotEquals(t1, object);
    }
    
    @Test
    public void testNotequalSizes() {
    	final int min = 0;
    	final int max = 100000;
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        insertRange(t1, min, max);
        AvlTree<Integer> t2 = new AvlTree<Integer>();
        insertRange(t2, min, max + 1);
        Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testStructurallyNotIdentical() {
    	final int min = 0;
    	final int max = 100000;
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        insertRange(t1, min, max);
        AvlTree<Integer> t2 = new AvlTree<Integer>();
        insertRange(t2, min + 1, max + 1);
        Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testStructurallIdentical() {
    	final int min = 0;
    	final int max = 100000;
        AvlTree<Integer> t1 = new AvlTree<Integer>();
        insertRange(t1, min, max);
        AvlTree<Integer> t2 = new AvlTree<Integer>();
        insertRange(t2, min, max);
        Assert.assertEquals(t1, t2);
    }
    
    @Test
    public void testLeftNodeMissing() {
    	AvlTree<Integer> t1 = new AvlTree<Integer>(10, 4, 18, 2, 20);
    	AvlTree<Integer> t2 = new AvlTree<Integer>(10, 4, 18, 6, 20);
    	Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testRightNodeMissing() {
    	AvlTree<Integer> t1 = new AvlTree<Integer>(10, 4);
    	AvlTree<Integer> t2 = new AvlTree<Integer>(10, 4, 18);
    	Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testLeftNodesNotEqual() {
    	AvlTree<Integer> t1 = new AvlTree<Integer>(10, 3, 18);
    	AvlTree<Integer> t2 = new AvlTree<Integer>(10, 4, 18);
    	Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testRightNodesNotEqual() {
    	AvlTree<Integer> t1 = new AvlTree<Integer>(10, 4, 16);
    	AvlTree<Integer> t2 = new AvlTree<Integer>(10, 4, 18);
    	Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testRootNodesNotEqual() {
    	AvlTree<Integer> t1 = new AvlTree<Integer>(12, 3, 45);
    	AvlTree<Integer> t2 = new AvlTree<Integer>(13, 3, 45);
    	Assert.assertNotEquals(t1, t2);
    }
    
    @Test
    public void testEmptyTreeHashCode() {
    	AvlTree<Integer> avlTree = new AvlTree<Integer>();
    	Assert.assertEquals(0, avlTree.hashCode());
    }
    
    @Test
    public void testSingleZeroNodeTreeHashCode() {
    	AvlTree<Integer> avlTree = new AvlTree<Integer>(0);
    	Assert.assertNotEquals(0, avlTree.hashCode());
    }
    
    @Test
    public void testRootAndLeftNodesTreeHashCode() {
    	Integer[] nodes = new Integer[] {12, 3};
    	AvlTree<Integer> avlTree = new AvlTree<Integer>(nodes);
    	int res = 17;
    	res = 31 * res + nodes[0].hashCode();
    	res = 31 * res + nodes[1].hashCode();
    	Assert.assertEquals(res, avlTree.hashCode());
    }
    
    @Test
    public void testRootAndRightNodesTreeHashCode() {
    	Integer[] nodes = new Integer[] {12, 30};
    	AvlTree<Integer> avlTree = new AvlTree<Integer>(nodes);
    	int res = 17;
    	res = 31 * res + nodes[0].hashCode();
    	res = 31 * res + nodes[1].hashCode();
    	Assert.assertEquals(res, avlTree.hashCode());
    }
    
    private void insertRange(AvlTree<Integer> tree, int min, int max) {
    	for (int i = min; i < max; i++) {
    		tree.insert(i);
    	}
    }
    
    @Test
    public void testEqualTreesEqualHashCodes() {
    	AvlTree<Integer> avlTree1 = new AvlTree<Integer>(1, 2, 3);
    	AvlTree<Integer> avlTree2 = new AvlTree<Integer>(1, 2, 3);
        Assert.assertEquals(avlTree1.hashCode(), avlTree2.hashCode());
    }

    @Test
    public void testSingleRotateLeft() {
        AvlTree<Integer> t1 = new AvlTree<Integer>(10);
        t1.insert(14, 56);
        Assert.assertEquals(t1.root.key, Integer.valueOf(14));
        Assert.assertEquals(t1.root.left.key, Integer.valueOf(10));
        Assert.assertEquals(t1.root.right.key, Integer.valueOf(56));
    }

    @Test
    public void testSingleRotateRight() {
        AvlTree<Integer> t1 = new AvlTree<Integer>(10);
        t1.insert(2, 1);
        Assert.assertEquals(t1.root.key, Integer.valueOf(2));
        Assert.assertEquals(t1.root.left.key, Integer.valueOf(1));
        Assert.assertEquals(t1.root.right.key, Integer.valueOf(10));
    }
    
    @Test
    public void testDoubleRotateLeftRight() {
        AvlTree<Integer> t1 = new AvlTree<Integer>(10);
        t1.insert(4, 9);
        Assert.assertEquals(t1.root.key, Integer.valueOf(9));
        Assert.assertEquals(t1.root.left.key, Integer.valueOf(4));
        Assert.assertEquals(t1.root.right.key, Integer.valueOf(10));
    }

    @Test
    public void testDoubleRotateRightLeft() {
        AvlTree<Integer> t1 = new AvlTree<Integer>(10);
        t1.insert(14, 12);
        Assert.assertEquals(t1.root.key, Integer.valueOf(12));
        Assert.assertEquals(t1.root.left.key, Integer.valueOf(10));
        Assert.assertEquals(t1.root.right.key, Integer.valueOf(14));
    }
    
    @Test
    public void testInsertDuplicate() {
    	AvlTree<Integer> avlTree = new AvlTree<Integer>(12, 12);
    	Assert.assertEquals(1, avlTree.getSize());
    }
    
    @Test
    public void testInitWithNull() {
    	AvlTree<Integer> avlTree = new AvlTree<Integer>(null);
    	Assert.assertNull(null, avlTree.root);
    }
    
    @Test(expected = NullPointerException.class)
    public void testInsertNull() {
    	Integer[] nodes = {
    			12, null
    	};
    	AvlTree<Integer> avlTree = new AvlTree<Integer>(nodes);
    }
    
    @Test
    public void testNodeEqual() {
    	Node<Integer> node = new Node<Integer>(1);
    	Node<Integer> node2 = node;
    	Assert.assertEquals(node, node2);
    }
    
}

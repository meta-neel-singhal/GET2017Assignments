package junittests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import operations.CheckMirror;

import org.junit.BeforeClass;
import org.junit.Test;

import binarytree.BinaryTree;
import binarytree.Node;

/**
 * The JUnit Test class.
 * 
 * @author Neel Singhal
 */
public class BinaryTreeTestCase {

	static BinaryTree tree;

	// Execute only once before the execution of any test case.
	@BeforeClass
	public static void initialize() {
		tree = new BinaryTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
	}

	// Positive test case.
	@Test
	public void insertTestCase1() {
		int expected = tree.root.getData();
		assertEquals(expected, 1);
	}

	// Positive test case.
	@Test
	public void preorderTestCase1() {
		int actual[] = {1, 3, 2};
		int	expected[] = {tree.preorder(tree.root).getData(), tree.preorder(tree.root.getLeft()).getData(),
				tree.preorder(tree.root.getRight()).getData()};	
		assertArrayEquals(expected, actual);
	}

	// Positive test case.
	@Test
	public void postorderTestCase1() {
		int actual[] = {3, 2, 1};
		int	expected[] = {tree.postorder(tree.root.getLeft()).getData(), tree.postorder(tree.root.getRight()).getData(), 
				tree.postorder(tree.root).getData()};	
		assertArrayEquals(expected, actual);
	}
	
	// Positive test case.
	@Test
	public void checkMirrorTestCase1() {
		Node firstTreeNode = new Node(2);
		Node secondTreeNode = new Node(2);
		// Nodes of first tree.
		firstTreeNode.left = new Node(9);
		firstTreeNode.right = new Node(2);
		firstTreeNode.left.left = new Node(7);
		firstTreeNode.left.right = new Node(4);
		
		// Nodes of second tree.
		secondTreeNode.left = new Node(2);
		secondTreeNode.right = new Node(9);
		secondTreeNode.right.left = new Node(4);
		secondTreeNode.right.right = new Node(7);

		assertTrue(CheckMirror.checkMirror(firstTreeNode, secondTreeNode));
	}

	// Negative test case.
	@Test
	public void insertTestCase2() {
		int expected = tree.root.getData();
		assertNotEquals(expected, 3);
	}

	// Negative test case.
	@Test
	public void preorderTestCase2() {
		int actual[] = {1, 2, 3};
		int	expected[] = {tree.preorder(tree.root).getData(), tree.preorder(tree.root.getLeft()).getData(),
				tree.preorder(tree.root.getRight()).getData()};	
		assertNotEquals(expected, actual);
	}

	// Negative test case.
	@Test
	public void postorderTestCase2() {
		int actual[] = {1, 2, 3};
		int	expected[] = {tree.postorder(tree.root.getLeft()).getData(), tree.postorder(tree.root.getRight()).getData(), 
				tree.postorder(tree.root).getData()};	
		assertNotEquals(expected, actual);
	}
	
	// Negative test case.
	@Test
	public void checkMirrorTestCase2() {
		Node firstTreeNode = new Node(1);
		Node secondTreeNode = new Node(1);
		// Nodes of first tree.
		firstTreeNode.left = new Node(9);
		firstTreeNode.right = new Node(2);
		firstTreeNode.left.left = new Node(7);
		firstTreeNode.left.right = new Node(4);
		
		// Nodes of second tree.
		secondTreeNode.left = new Node(9);
		secondTreeNode.right = new Node(2);
		secondTreeNode.right.left = new Node(7);
		secondTreeNode.right.right = new Node(4);

		assertFalse(CheckMirror.checkMirror(firstTreeNode, secondTreeNode));
	}
}
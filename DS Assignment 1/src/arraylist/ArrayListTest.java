package arraylist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert.*;

public class ArrayListTest {

	// Positive test case 1.
	@Test
	public void addTestCase1() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		assertEquals(1, obj.getElement(5));
	}

	// Positive test case 2.
	@Test
	public void addByIndexTestCase1() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElementByIndex(2, 7);
		assertEquals(3, obj.getElement(7));
	}

	// Positive test case 3.
	@Test
	public void sizeTestCase1() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		assertEquals(3, obj.getSize());
	}

	// Positive test case 4.
	@Test
	public void removeElementByPositionTestCase1() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		obj.removeElementFromPosition(1);
		assertEquals(-1, obj.getElement(6));
	}

	// Positive test case 5.
	@Test
	public void removeElementTestCase1() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		assertEquals(true, obj.removeElement(8));
	}

	// Positive test case 6.
	@Test
	public void deleteAllTestCase1() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		obj.deleteAllElements();
		assertEquals(-1, obj.getElement(5));
	}

	// Positive test case 7.
	@Test
	public void reverseArrayTestCase() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		Object expected[] = obj.printArrayList();
		obj.reverseArrayList();
		Object actual[] = obj.printArrayList();
		assertFalse(actual == expected);
	}

	// Negative test case 1.
	@Test
	public void addTestCase2() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(6);
		int expected = 1;
		assertFalse(expected == obj.getElement(7));
	}

	// Negative test case 2.
	@Test
	public void addByIndexTestCase2() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElementByIndex(2, 7);
		assertFalse(1 == obj.getElement(7));
	}

	// Negative test case 3.
	@Test
	public void sizeTestCase2() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		assertFalse(4 == obj.getSize());
	}

	// Negative test case 4.
	@Test
	public void removeElementByPositionTestCase2() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		obj.removeElementFromPosition(1);
		assertFalse(1 == obj.getElement(6));
	}

	// Negative test case 5.
	@Test
	public void removeElementTestCase2() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		assertFalse(false == obj.removeElement(8));
	}

	// Negative test case 6.
	@Test
	public void deleteAllTestCase2() {
		MyArrayList<Integer> obj = new MyArrayList<Integer>();
		obj.addElement(5);
		obj.addElement(6);
		obj.addElement(8);
		obj.deleteAllElements();
		assertFalse(1 == obj.getElement(5));
	}
}

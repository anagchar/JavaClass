package Intlist;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntlistTest {

	@Test
	void ConstructorAndGetters() {
		Intlist array = new Intlist(new int[] {1,3,4,5});
		assertArrayEquals(new int[] {1,3,4,5}, array.getElements());
		assertEquals(1, array.getElementAt(0));
	}
	
	@Test
	void addTest() {
		Intlist array = new Intlist(new int[] {1,3,4,5});
		array.add(22);
		assertArrayEquals(new int[] {1,3,4,5,22}, array.getElements());
	}
	
	@Test
	void removeTest() {
		Intlist array = new Intlist(new int[] {1,3,4,5});
		array.removeLast();
		assertArrayEquals(new int[] {1,3,4}, array.getElements());
	}

}

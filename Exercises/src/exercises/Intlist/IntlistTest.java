package exercises.Intlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntlistTest {

	@Test
	void test() {
		Intlist myIntList = new Intlist(new int[] {10, 20, 30});
		assertArrayEquals(new int[] {10, 20, 30}, myIntList.getElements());
		assertEquals(3, myIntList.getLength());
		assertEquals(10, myIntList.getElementAt(0));
		
		myIntList.add(40);
		assertArrayEquals(new int[] {10, 20, 30, 40}, myIntList.getElements());
		assertEquals(4, myIntList.getLength());
		assertEquals(40, myIntList.getElementAt(3));
		
		myIntList.removeLast();
		assertArrayEquals(new int[] {10, 20, 30}, myIntList.getElements());
		assertEquals(3, myIntList.getLength());
		assertEquals(30, myIntList.getElementAt(2));
		
	}

}

package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntlistTest {

	@Test
	void test() {
		int[] elements = new int[3];
		Intlist list = new Intlist(elements, 0);
		list.add(1, 0);
		list.add(2, 1);
		list.add(3, 2);
		int[] result = list.toArray();
		assertArrayEquals(new int[] { 1, 2, 3 }, result);
	}

}

package exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SequencesTest {

	@Test
	void test() {
		Sequences mySequence1 = new EmptySequence();
		Sequences mySequence2 = new NonEmptySequence(1, new NonEmptySequence(5, new EmptySequence()));
		assertTrue(mySequence1.getLength() == 0);
		assertTrue(mySequence2.getLength() == 2);
		assertNotEquals(new EmptySequence(), mySequence1);
		assertNotEquals(new NonEmptySequence(1, new NonEmptySequence(5, new EmptySequence())), mySequence2);
		assertEquals("[1, 5]", mySequence2.toString());
		assertEquals("[]", mySequence1.toString());
	}
	
}


package exercises.Sequence;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SequencesTest {

	@Test
	void test() {
		Sequences mySequence1 = new EmptySequence();
		Sequences tail_of2 = new NonEmptySequence(5, new EmptySequence());
		Sequences mySequence2 = new NonEmptySequence(1, tail_of2);
		assertTrue(mySequence1.getLength() == 0);
		assertTrue(mySequence2.getLength() == 2);
		assertEquals(new EmptySequence(), mySequence1);
		assertEquals(new NonEmptySequence(1, new NonEmptySequence(5, new EmptySequence())), mySequence2);
		assertEquals("[1, 5]", mySequence2.toString());
		assertEquals("[]", mySequence1.toString());
		assertEquals(1, ((NonEmptySequence) mySequence2).getHead());
		assertEquals(tail_of2, ((NonEmptySequence) mySequence2).getTail());
	}
	
}


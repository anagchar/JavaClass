package Sequence;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class SequenceTest {

	@Test
	void test() {
		Sequence mySequence1 = new EmptySequence();
		Sequence tail_of2 = new NonEmptySequence(5, new EmptySequence());
		Sequence mySequence2 = new NonEmptySequence(1, tail_of2);
		assertTrue(mySequence1.getLength() == 0);
		assertTrue(mySequence2.getLength() == 2);
		assertEquals(new EmptySequence(), mySequence1);
		assertEquals(new NonEmptySequence(1, new NonEmptySequence(5, new EmptySequence())), mySequence2);
		assertEquals(1, ((NonEmptySequence) mySequence2).getHead());
		assertEquals(tail_of2, ((NonEmptySequence) mySequence2).getTail());
	}

}

package interval_oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntervalTest {
	
	@Test
	void test() {
		Interval myInterval = new Interval(3,7);
		int length = myInterval.getUpperBound() - myInterval.getLowerBound();
		assertEquals(4, length);
	}

}

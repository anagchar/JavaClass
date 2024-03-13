package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay myTime = new TimeOfDay(3, 44);
		assertEquals(3, myTime.getHours());
		assertEquals(44, myTime.getMinutes());
		int midnights = myTime.getMinutesSinceMidnight();
		boolean check = myTime.isBefore(new TimeOfDay(4, 44));
	}

}

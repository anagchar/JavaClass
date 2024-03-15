package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay myTime = new TimeOfDay(10, 30);
		assertEquals(10, myTime.getHours());
		assertEquals(30, myTime.getMinutes());
		assertEquals(630, myTime.getMinutesSinceMidnight());
		
		myTime.setHours(13);
		assertEquals(13, myTime.getHours());
		assertEquals(30, myTime.getMinutes());
		assertEquals(810, myTime.getMinutesSinceMidnight());
		
		myTime.setMinutes(0);
		assertEquals(13, myTime.getHours());
		assertEquals(0, myTime.getMinutes());
		assertEquals(780, myTime.getMinutesSinceMidnight());
		
		myTime.setMinutesSinceMidnight(1140);
		assertEquals(19, myTime.getHours());
		assertEquals(0, myTime.getMinutes());
		assertEquals(1140, myTime.getMinutesSinceMidnight());
		
		int midnights = myTime.getMinutesSinceMidnight();
		boolean check = myTime.isBefore(new TimeOfDay(4, 44));
	}

}

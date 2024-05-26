package TimeOfDay;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void ConstructorandGettersTest() {
		TimeOfDay Monday = new TimeOfDay(2, 44);
		assertEquals(2, Monday.getHours());
		assertEquals(44, Monday.getMinutes());
		assertEquals(164, Monday.getMinutesSinceMidnight());
		assertThrows(IllegalArgumentException.class, () -> 
		new TimeOfDay(-1, 22));
		assertThrows(IllegalArgumentException.class, () -> 
		new TimeOfDay(1, 322));
	}
	
	@Test
	void SettersTest() {
		TimeOfDay Monday = new TimeOfDay(2, 44);
		Monday.setHours(4);
		assertEquals(4, Monday.getHours());
		Monday.setMinutes(7);
		assertEquals(7, Monday.getMinutes());
		Monday.setMinutesSinceMidnight(33);
		assertEquals(33, Monday.getMinutesSinceMidnight());
	}

}

package Aircraft;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class AircraftTest {

	@Test
	void test() {
		AirportATC Brussels = new AirportATC(33);
		Aircraft Boeing777 = new Aircraft(Brussels);
				
		assertEquals(Brussels, Boeing777.getATC());
		assertThrows(IllegalArgumentException.class, () -> {
			new Aircraft(null);
		});
		assertEquals(0, Boeing777.getSpeed());
		Boeing777.setSpeed(66);
		assertEquals(66, Boeing777.getSpeed());
		
		AirportATC El_Venizelos = new AirportATC(29);
		Boeing777.transferToATC(El_Venizelos);
		assertEquals(El_Venizelos, Boeing777.getATC());
		
		Aircraft Boeing787 = new Aircraft(El_Venizelos);
		
		assertEquals(Set.of(Boeing777, Boeing787), El_Venizelos.getControlls());		
		assertTrue(El_Venizelos.permissionToLand(Boeing777));
		assertFalse(El_Venizelos.isSimilarTo(Brussels));
		
		
	}

}

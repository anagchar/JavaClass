package Airports;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class AirportTest {

	@Test
	void test() {
		Airport El_Venizelos = new Airport();
		Airport Charleroi = new Airport();
		assertEquals(Set.of(), El_Venizelos.getConnected());
		assertEquals(Set.of(), Charleroi.getConnected());
		
		El_Venizelos.connectedWith(Charleroi);
		assertEquals(Set.of(Charleroi), El_Venizelos.getConnected());
		assertEquals(Set.of(El_Venizelos), Charleroi.getConnected());
		
		Charleroi.disconnectedWith(El_Venizelos);
		assertEquals(Set.of(), El_Venizelos.getConnected());
		assertEquals(Set.of(), Charleroi.getConnected());
	}

}

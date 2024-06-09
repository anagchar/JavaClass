package Entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class EntityTest {

	@Test
	void test() {
		Person Daan = new Person();
		assertEquals(Set.of(), Daan.getOwnedCompanies());
		
		Company Zara = new Company(Daan);
		assertEquals(Daan, Zara.getOwner());
		
		Person George = new Person();
		Zara.transferTo(George);
		assertEquals(George, Zara.getOwner());
	}

}

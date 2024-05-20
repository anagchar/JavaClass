package persons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test() {
		Person albert = new Person();
		assertNull(albert.getFather());
		assertEquals(Set.of(), albert.getChildren());
		
		Person philippe = new Person();
		philippe.setFather(albert);
		assertSame(albert, philippe.getFather());
		assertEquals(Set.of(philippe), albert.getChildren());
		
		Person laurent = new Person();
		laurent.setFather(albert);
		assertEquals(Set.of(philippe, laurent), albert.getChildren());
		
		laurent.clearFather();
		assertNull(laurent.getFather());
		assertEquals(Set.of(philippe), albert.getChildren());
		 
	}

}

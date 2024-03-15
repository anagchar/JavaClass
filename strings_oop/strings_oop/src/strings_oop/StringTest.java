package strings_oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		char[] myChars = {'H', 'e', 'l', 'l', 'o'};
		String myString = new String(myChars);
		assertArrayEquals(new char[] {'H', 'e', 'l', 'l', 'o'}, myString.toCharArray());
		assertEquals(5, myString.length());
		assertEquals('H', myString.charAt(0));
		
		/*
		 * SOS toCharArray() -> getter method not to be exposed to the client
		 * SOS length() -> getter method not to be exposed to the client
		 * SOS String() -> constructor method not to be exposed to the client
		 * The others doesn't leak any reference to the client
		 */
		
		
	}

}

package colors_oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class TransparentColorTest {

	@Test
	void test() {
		TransparentColor myColor = new TransparentColor(100, 100, 100, 50);
		//myColor.getHue();
		assertTrue(myColor instanceof Color); //inheretance relation
		assertTrue(myColor.red == 100);
		assertTrue(myColor.getClass() == TransparentColor.class);
	}

}

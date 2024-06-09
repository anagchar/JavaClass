package Network;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class NodeAppearanceTest {

	@Test
	void test() {
		SquareNodeAppearance a1 = new SquareNodeAppearance(Color.red, 5);
		assertEquals(Color.red, a1.getColor());
		assertEquals(5, a1.getWidth());
		
		assertEquals(a1, new SquareNodeAppearance(Color.red, 5));
		assertNotEquals(a1, new SquareNodeAppearance(Color.green, 5));
		assertNotEquals(a1, new SquareNodeAppearance(Color.red, 7));
			
		CircularNodeApperance a2 = new CircularNodeApperance(Color.blue, 9);
		assertEquals(Color.blue, a2.getColor());
		assertEquals(9, a2.getRadius());
		
		assertEquals(a2, new CircularNodeApperance(Color.blue, 9));
		assertNotEquals(a2, new CircularNodeApperance(Color.cyan, 9));
		assertNotEquals(a2, new CircularNodeApperance(Color.blue, 11));
		
		assertNotEquals(a1, a2);
		assertNotEquals(a2, a1);
	}

}

package Network;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	void test() {
		Node neural1 = new Node();
		assertEquals(Set.of(), neural1.getNeighbors());
		
		Node neural2 = new Node();
		Node neural3 = new Node();
		neural1.linkNodes(neural3);
		neural1.linkNodes(neural2);
		assertEquals(Set.of(neural2, neural3), neural1.getNeighbors());
		
		assertThrows(IllegalArgumentException.class, () -> {
			neural2.linkNodes(neural1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			neural1.linkNodes(null);
		});
		
		neural3.removeLink(neural1);
		assertEquals(Set.of(neural2), neural1.getNeighbors());
	}

}

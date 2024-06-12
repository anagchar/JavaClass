package GraphDiagramTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import GraphDiagram.Arc;
import GraphDiagram.CircularNode;
import GraphDiagram.Node;
import GraphDiagram.RectangularNode;

class GraphDiagramTest {

	@Test
	void RectangularNodeTest() {
		RectangularNode Rect1 = new RectangularNode(2, 2);
		assertEquals(2, Rect1.getWidth());
		assertEquals(2, Rect1.getHeight());
		assertThrows(IllegalArgumentException.class, () -> {
            // Create an instance of RectangularNode with invalid parameters
            new RectangularNode(-2, -1);
        });
		assertEquals(4, Rect1.AreaOfNode());
		
		RectangularNode Rect2 = new RectangularNode(2, 2);
		RectangularNode Rect3 = new RectangularNode(1, 2);
		assertTrue(Rect1.isIsomorphicWith(Rect2));
		assertFalse(Rect2.isIsomorphicWith(Rect3));
	}
	
	@Test
	void CircularNodeTest() {
		CircularNode Circ = new CircularNode(3);
		assertEquals(3, Circ.getRadius());
		assertThrows(IllegalArgumentException.class, () -> {
            new CircularNode(-2);
        });
		assertEquals(9, Circ.AreaOfNode());
		
		CircularNode Circ1 = new CircularNode(3);
		CircularNode Circ2 = new CircularNode(4);
		assertTrue(Circ.isIsomorphicWith(Circ1));
		assertFalse(Circ1.isIsomorphicWith(Circ2));
		
	}
	
	@Test
	void ArcTest() {
		Arc arc1 = new Arc(90);
		assertEquals(90, arc1.getDepartureAngle());
		assertThrows(IllegalArgumentException.class, () -> {
            new Arc(-2);
        });
		
		RectangularNode Rect1 = new RectangularNode(2, 2);  
		RectangularNode Rect2 = new RectangularNode(3, 2);  
		assertNull(arc1.getSourceNode());
		assertNull(arc1.getTargetNode());
		arc1.setSourceNode(Rect1);
		arc1.setTargetNode(Rect2);
		assertSame(Rect1, arc1.getSourceNode());
		assertSame(Rect2, arc1.getTargetNode());
		arc1.unlinkSourceNode();
		assertNull(arc1.getSourceNode());
		arc1.unlinkTargetNode();
		assertNull(arc1.getTargetNode());
		
		RectangularNode rn1 = new RectangularNode(10, 5);
		CircularNode cn1 = new CircularNode(100);
		Arc a1 = new Arc(45);
		assertEquals(45, a1.getDepartureAngle());
		assertNull(a1.getSourceNode());
		assertNull(a1.getTargetNode());
		
		a1.setSourceNode(rn1);
		assertSame(rn1, a1.getSourceNode());
		assertEquals(Set.of(a1), rn1.getOutgoingArcs());
		
		a1.setTargetNode(cn1);
		assertSame(cn1, a1.getTargetNode());
		assertEquals(Set.of(a1), cn1.getIncomingArcs());
		
		a1.unlinkSourceNode();
		assertNull(a1.getSourceNode());
		assertEquals(Set.of(), rn1.getOutgoingArcs());
		
		a1.unlinkTargetNode();
		assertNull(a1.getTargetNode());
		assertEquals(Set.of(), cn1.getIncomingArcs());
	}

}

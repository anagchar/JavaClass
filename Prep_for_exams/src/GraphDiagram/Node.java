package GraphDiagram;

import java.util.Set;

sealed abstract class Node permits RectangularNode, CircularNode{
	
	Set<Arc> outgoingArcs;
	
	Set<Arc> incomingArcs;

}

package GraphDiagram;

import java.util.HashSet;
import java.util.Set;

sealed abstract class Node permits RectangularNode, CircularNode{
	
	/**
	 * @invar | outgoingArcs != null && incomingArcs != null
	 */
	Set<Arc> outgoingArcs = new HashSet<>();
	
	Set<Arc> incomingArcs = new HashSet<>();
	
	public Node() {}
	
	public Set<Arc> getOutgoingArcs() {
		return Set.copyOf(outgoingArcs);
	}
	
	public Set<Arc> getIncomingArcs() {
		return Set.copyOf(incomingArcs);
	}
	
	public abstract int AreaOfNode();
	
	public abstract boolean isIsomorphicWith(Node other);

}

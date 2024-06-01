package GraphDiagram;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getOutgoingArcs().stream().allMatch(arc -> arc != null && arc.getSourceNode() == this)
 * @invar | getIncomingArcs().stream().allMatch(arc -> arc != null && arc.getTargetNode() == this)
 */
public sealed abstract class Node permits RectangularNode, CircularNode{
	
	/**
	 * @invar | outgoingArcs != null && incomingArcs != null
	 * @invar | outgoingArcs.stream().allMatch(arc -> arc != null && arc.sourceNode == this)
	 * @invar | incomingArcs.stream().allMatch(arc -> arc != null && arc.targetNode == this)
	 * @peerObjects
	 * @representationObject
	 */
	Set<Arc> outgoingArcs = new HashSet<>();
	
	/**
	 * @peerObjects
	 * @representationObject
	 */
	Set<Arc> incomingArcs = new HashSet<>();
	
	public Node() {}
	
	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Arc> getOutgoingArcs() {
		return Set.copyOf(outgoingArcs);
	}
	
	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Arc> getIncomingArcs() {
		return Set.copyOf(incomingArcs);
	}
	
	public abstract int AreaOfNode();
	
	public abstract boolean isIsomorphicWith(Node other);

}

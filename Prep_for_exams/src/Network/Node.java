package Network;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*;

/**
 * @invar | getNeighbors() != null
 * @invar | getNeighbors().stream().allMatch(node -> node != null && node.getNeighbors().contains(this))
 */
public class Node {
	
	/**
	 * @invar | neighbors != null
	 * @invar | neighbors.stream().allMatch(node -> node != null && node.neighbors.contains(this))
	 * 
	 * @representationObject
	 * @peerObject
	 */
	private Set<Node> neighbors = new HashSet<>();
	
	/**
	 * 
	 * @peerObject
	 */
	public Set<Node> getNeighbors() {
		return Set.copyOf(neighbors);
	}
	
	
	/**
	 * @throws IllegalArgumentException | other == null
	 * @throws IllegalArgumentException | getNeighbors().contains(other)
	 * @mutates_properties | getNeighbors(), other.getNeighbors()
	 * @post | getNeighbors().equals(LogicalSet.plus(old(getNeighbors()), other))
	 * @post | other.getNeighbors().equals(LogicalSet.plus(old(other.getNeighbors()), this))
	 */
	public void linkNodes(Node other) {
		if (other == null) {
			throw new IllegalArgumentException("The 'other' node cannot be null!");
		}
		if (this.getNeighbors().contains(other)) {
			throw new IllegalArgumentException("The nodes are already linked!");
		}
		this.neighbors.add(other);
		other.neighbors.add(this);
	}
	
	/**
	 * @pre | linkedNode != null
	 * @pre | getNeighbors().contains(linkedNode)
	 * @mutates_properties | getNeighbors(), linkedNode.getNeighbors()
	 * @post | getNeighbors().equals(LogicalSet.minus(old(getNeighbors()), linkedNode))
	 * @post | linkedNode.getNeighbors().equals(LogicalSet.minus(old(linkedNode.getNeighbors()), this))
	 */
	public void removeLink(Node linkedNode) {
		this.neighbors.remove(linkedNode);
		linkedNode.neighbors.remove(this);
	}
	
	/**
	 * @post | getNeighbors().isEmpty()
	 */
	public Node() {}

}

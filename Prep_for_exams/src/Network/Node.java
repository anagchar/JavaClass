package Network;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*;

/**
 * @invar | getNode() != null
 * @invar | getNeighbors() != null
 * @invar | getNeighbors().stream().allMatch(node -> node != null && node.getNeighbors().contains(this))
 */
public class Node {
	
	/**
	 * @invar | node != null
	 * @invar | neighbors != null
	 * @invar | neighbors.stream().allMatch(node -> node != null && node.getNeighbors().contains(this))
	 * 
	 * @representationObject
	 * @peerObject
	 */
	Node node;
	Set<Node> neighbors = new HashSet<>();
	
	/**
	 * 
	 * @peerObject
	 */
	public Set<Node> getNeighbors() {
		return Set.copyOf(neighbors);
	}
	
	/**
	 * 
	 * @post | result != null
	 * 
	 */
	public Node getNode() {
		return node;
	}
	
	/**
	 * @throws IllegalArgumentException | other == null
	 * @throws IllegalArgumentException | getNode().getNeighbors().contains(other)
	 * @mutates_properties | getNode().getNeighbors(), other.getNeighbors()
	 * @post | getNode().getNeighbors().equals(LogicalSet.plus(old(getNode().getNeighbors()), other))
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
	 * @pre | !(getNode().getNeighbors().contains(linkedNode))
	 * @mutates_properties | getNode().getNeighbors(), linkedNode.getNeighbors()
	 * @post | getNode().getNeighbors().equals(LogicalSet.minus(old(getNode().getNeighbors()), this))
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

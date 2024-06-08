package GraphDiagram;

import java.util.Collection;
import java.util.Set;
import logicalcollections.*;

/**
 * @invar | getDepartureAngle() >= 0 && getDepartureAngle() <= 359
 * @invar | getSourceNode() == null || getSourceNode().getOutgoingArcs().contains(this)
 * @invar | getTargetNode() == null || getTargetNode().getIncomingArcs().contains(this)
 */
public class Arc {
	
	/**
	 * @invar | 0 <= departureAngle 
	 * @invar | departureAngle <= 359
	 * @invar | sourceNode == null || sourceNode.outgoingArcs.contains(this)
	 * @invar | targetNode == null || targetNode.incomingArcs.contains(this)
	 */
	int departureAngle;
	
	Node sourceNode;
	
	Node targetNode;
	
	/**
	 * 
	 * @inspects | this
	 */
	public int getDepartureAngle() { 
		return this.departureAngle;
	}
	
	/**
	 * 
	 * @peerObject
	 */
	public Node getSourceNode() { 
		return sourceNode; 
	}
	
	/**
	 * 
	 * @peerObject
	 * 
	 */
	public Node getTargetNode() { 
		return targetNode; 
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException | departureAngle < 0 || departureAngle > 359
	 * @post | getDepartureAngle() == departureAngle
	 * @post | getSourceNode() == null
	 * @post | getTargetNode() == null
	 * 
	 */
	public Arc(int departureAngle) {
		if (departureAngle < 0 || departureAngle > 359) {
			throw new IllegalArgumentException("This departure angle is out of the bounds");
		}
		this.departureAngle = departureAngle;
		
	}
	
	/** 
	 * @pre | sourceNode != null
	 * @pre | getSourceNode() == null
	 * @mutates_properties | this.getSourceNode(), sourceNode.getOutgoingArcs()
	 * @post | getSourceNode() != null
	 * @post | sourceNode.getOutgoingArcs().equals(LogicalSet.plus(old(sourceNode.getOutgoingArcs()), this))
	 * 
	 */
	public void setSourceNode(Node sourceNode) { 
		this.sourceNode = sourceNode; 
		sourceNode.outgoingArcs.add(this);
	}
	
	/**
	 * @pre | targetNode != null
	 * @pre | getTargetNode() == null
	 * @mutates_properties | this.getTargetNode(), targetNode.getOutgoingArcs()
	 * @post | getTargetNode() != null
	 * @post | targetNode.getIncomingArcs().equals(LogicalSet.plus(old(targetNode.getIncomingArcs()), this))
	 *
	 */
	public void setTargetNode(Node targetNode) { 
		this.targetNode = targetNode;
		targetNode.incomingArcs.add(this);
	}
	
	/**
	 * @pre | getSourceNode() != null
	 * @mutates_properties | this.getSourceNode(), getSourceNode().getOutgoingArcs()
	 * @post | getSourceNode() == null
	 * @post | old(getSourceNode()).getOutgoingArcs().equals(LogicalSet.minus(old(getSourceNode().getOutgoingArcs()), this))
	 */
	public void unlinkSourceNode() { 
		sourceNode.outgoingArcs.remove(this);
		this.sourceNode = null;
	}
	
	/**
	 * @pre | getTargetNode() != null
	 * @mutates_properties | this.getTargetNode(), getTargetNode().getIncomingArcs()
	 * @post | getTargetNode() == null
	 * @post | old(getTargetNode()).getIncomingArcs().equals(LogicalSet.minus(old(getTargetNode().getIncomingArcs()), this))
	 */
	public void unlinkTargetNode() { 	
		targetNode.incomingArcs.remove(this);
		this.targetNode = null;
	}
	
	
	

}

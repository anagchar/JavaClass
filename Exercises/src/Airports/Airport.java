package Airports;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getConnected().stream().allMatch(a -> a != null && a.getConnected().contains(this))
 */
public class Airport {
	
	/**
	 * @invar | Airports != null
	 * @invar | Airports.stream().allMatch(a -> a != null && a.getConnected().contains(this))
	 * 
	 * @representationObject 
	 * @peerObjects
	 */
	private Set<Airport> Airports = new HashSet<>();
	
	/**
	 * @creates | result
	 * 
	 * @peerObjects
	 * 
	 * @post | result != null
	 * @post | result.stream().allMatch(a -> a != null)
	 */
	public Set<Airport> getConnected(){
		return Set.copyOf(Airports);
	}
	
	public Airport() {}
	
	
	/**
	 * @pre | other != null
	 * @mutates_properties | this.getConnected(), other.getConnected()
	 * @post | this.getConnected().equals(LogicalSet.plus(old(this.getConnected()), other))
	 * @post | other.getConnected().equals(LogicalSet.plus(old(other.getConnected()), this))
	 */
	public void connectedWith(Airport other) {
		this.Airports.add(other);
		other.Airports.add(this);
	}
	
	/**
	 * @pre | other != null
	 * @mutates_properties | this.getConnected(), other.getConnected()
	 * @post | this.getConnected().equals(LogicalSet.minus(old(this.getConnected()), other))
	 * @post | other.getConnected().equals(LogicalSet.minus(old(other.getConnected()), this))
	 * 
	 */
	public void disconnectedWith(Airport other) {
		this.Airports.remove(other);
		other.Airports.remove(this);
	}

}

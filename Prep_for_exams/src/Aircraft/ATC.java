package Aircraft;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getControlls() != null
 * @invar | getControlls().stream().allMatch(craft -> craft != null && craft.getATC() == this)
 */
public abstract class ATC {
	
	/**
	 * @invar | controlls != null
	 * @invar | 1 <= gates
	 * @invar | controlls.stream().allMatch(craft -> craft != null && craft.getATC() == this)
	 * @representationObject
	 * @peerObjects
	 */
	final int gates;
	Set<Aircraft> controlls = new HashSet<>();
	
	ATC(int gates) {
		this.gates = gates;
	}
	
	/**
	 * 
	 * @creates | result
	 * 
	 * @peerObjects
	 */
	public abstract Set<Aircraft> getControlls(); 
	
	/**
	 * @pre | plane != null
	 */
	public abstract boolean permissionToLand(Aircraft plane);
	
	/**
	 * @pre | other != null
	 */
	public abstract boolean isSimilarTo(ATC other);
	
}

package Aircraft;

import java.util.Set;

/**
 * @invar | 1 <= getGates()
 */
public class AirportATC extends ATC {

	/**
	 * @pre | 1 <= gates
	 * @post | getControlls().isEmpty()
	 * @post | getGates() == gates
	 */
	AirportATC(int gates) {
		super(gates);
	}

	@Override
	public Set<Aircraft> getControlls() {
		return Set.copyOf(this.controlls);
	}
	
	/**
	 * @post | 1 <= result
	 * @inspects | this
	 */
	public int getGates() {
		return gates;
	}

	@Override
	public boolean permissionToLand(Aircraft plane) {
		return plane.getSpeed() < 300;
	}

	@Override
	public boolean isSimilarTo(ATC other) {
		return other instanceof AirportATC atc && atc.getGates() == this.getGates();
	}

}

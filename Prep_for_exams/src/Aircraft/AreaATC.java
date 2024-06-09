package Aircraft;

import java.util.Set;

public class AreaATC extends ATC{

	/**
	 * @post | getControlls().isEmpty()
	 */
	AreaATC(int gates) {
		super(gates);
	}

	@Override
	public Set<Aircraft> getControlls() {
		return null;
	}

	@Override
	public boolean permissionToLand(Aircraft plane) {
		return false;
	}

	@Override
	public boolean isSimilarTo(ATC other) {
		return other instanceof AreaATC;
	}

}

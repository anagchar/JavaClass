package Airports;

import java.util.HashSet;
import java.util.Set;

public class Airport {
	
	private Set<Airport> Airports = new HashSet<>();
	
	public Set<Airport> getConnected(){
		return Set.copyOf(Airports);
	}
	
	public Airport() {}
	
	public void connectedWith(Airport other) {
		this.getConnected().add(other);
		other.getConnected().add(this);
	}
	
	public void disconnectedWith(Airport other) {
		this.getConnected().remove(other);
		other.getConnected().remove(this);
	}

}

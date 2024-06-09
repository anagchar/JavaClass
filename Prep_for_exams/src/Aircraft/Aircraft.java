package Aircraft;

import java.util.Set;
import logicalcollections.*;

/**
 * @invar | getSpeed() >= 0
 * @invar | getATC() != null
 * @invar | getATC().getControlls().contains(this)
 */
public class Aircraft {
	
	/**
	 * @invar | AirportATC.getControlls().contains(this)
	 * @invar | AirportATC != null
	 * 
	 * @peerObject
	 */
	AirportATC AirportATC;
	
	/**
	 * @invar | speed >= 0
	 */
	int speed;
	
	/**
	 * @throws IllegalArgumentException | AirportATC == null
	 * @mutates_porperties | AirportATC.getControlls()
	 * @post | getATC() == AirportATC
	 * @post | AirportATC.getControlls().equals(LogicalSet.plus(old(AirportATC.getControlls()), this))
	 * @post | getSpeed() == 0
	 */
	public Aircraft(AirportATC AirportATC) {
		if (AirportATC == null) {
			throw new IllegalArgumentException("The AirportATC could not be null!");
		}
		this.AirportATC = AirportATC;
		AirportATC.controlls.add(this);
	}
	
	/**
	 * @post | result >= 0
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * @pre | speed >= 0
	 * @mutates_properties | getSpeed()
	 * @post | getSpeed() == speed
	 * @post | getSpeed() >= 0
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * @pre | newATC != null
	 * @mutates_properties | this.getATC(), newATC.getControlls()
	 * 
	 * @post | getATC() == newATC
	 * @post | getATC().getControlls().equals(LogicalSet.plus(old(getATC().getControlls()), this))
	 */
	public void transferToATC(AirportATC newATC) {
		this.AirportATC.controlls.remove(this);
		this.AirportATC = newATC;
		newATC.controlls.add(this);
	}
	
	/**
	 * @post | result != null
	 * 
	 */
	public AirportATC getATC() {
		return this.AirportATC;
	}
	
	

}

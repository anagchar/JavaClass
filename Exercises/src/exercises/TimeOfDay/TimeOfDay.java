package exercises.TimeOfDay;

// Procedure for developing a data abstraction:
// 	1. Develop the API
// 		1.1 Write a line of informal documentation for the class, stating what an instance represents/stores.
//		1.2 Define the raw abstract state space (i.e declare the getters/inspectors).
//		1.3 Define the valid abstract state space (i.e write the abstract state invariants).
//		1.4 Declaring and documenting the constructors and mutators
// 	2. Implement the API
// 		2.1 Define the representation (store the abstract state and compute the memory)
// 			2.1.1. Define the raw concrete state space (i.e declare the fields)
// 			2.1.2. Define the valid concrete state space (i.e write the representation invariants a.k.a concrete state invariants).
// 			2.1.3 Define the abstraction function (i.e. implement the getters/inspectors).
//			2.1.4 Perform sanity checks:
//				A. The inspectors should not crash when called in any valid concrete state 
//				B. Valid
//		2.2 Implement the constructors and the mutators

/**
 * Each instance of this class stores a time of day in hours and minutes.
 * 
 * @invar The hours are between 0 and 23. | 0 <= getHours() && getHours() <= 23
 * @invar The minutes are between 0 and 59. | 0 <= getMinutes() && getMinutes() <= 59
 * @invar getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 * 
 */

public class TimeOfDay {
	
	/**
	 * @invar | 0 <= hours && hours <= 23
	 * @invar | 0 <= minutes && minutes <= 59
     */
	private int hours;
	private int minutes;
	
	/**
	 * @invar | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24 * 60
	 */
	private int minutesSinceMidnight;
	
	/** Constructor
	 * 
	 * 
	 * @throws IllegalArgumentException if the given hours are not between 0
     *         and 23
     *    | !(0 <= hours && hours <= 23)
     * @throws IllegalArgumentException if the given minutes are not between 0
     *         and 59
     *    | !(0 <= minutes && minutes <= 59)
     *    
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
     */
	public TimeOfDay(int hours, int minutes) {
		if (!(0 <= hours && hours <= 23))
            throw new IllegalArgumentException("hours out of range");
        if (!(0 <= minutes && minutes <= 59))
            throw new IllegalArgumentException("minutes out of range");
		this.hours = hours;
		this.minutes = minutes;
		this.minutesSinceMidnight = hours * 60 + minutes;
	}
	
	/** Sets the hours to the given value
	 * 
	 * @throws IllegalArgumentException | newHours < 0 || 24 <= newHours
	 * 
	 * @mutates | this
	 * 
	 * @post | getHours() == newHours
	 * @post | getMinutes() == old(getMinutes())
	 * 
	 */
	public void setHours(int newHours) {
		if (newHours < 0 || 24 <= newHours) {
			throw new IllegalArgumentException("Bad 'initialNbHours' ");
		}
		this.hours = newHours;
		
		this.minutesSinceMidnight = newHours * 60 + minutesSinceMidnight % 60;
		
		
	}
	
	/** Sets the minutes to the given value
	 * 
	 * @throws IllegalArgumentException | newMinutes < 0 || 24 <= newMinutes
	 * 
	 * @mutates | this
	 * 
	 * @post | getMinutes() == newMinutes
	 * @post | getHours() == old(getHours())
	 * 
	 */
	public void setMinutes(int newMinutes) {
		if (newMinutes < 0 || 24 <= newMinutes) {
			throw new IllegalArgumentException("Bad 'initialNbMinutes' ");
		}
		this.minutes = newMinutes;
		
		this.minutesSinceMidnight = minutesSinceMidnight - minutesSinceMidnight % 60 + newMinutes;
		
		
	}
	
	/**
	 * @pre | 0 <= newMinutesSinceMidnight && newMinutesSinceMidnight < 24 * 60
	 * 
	 * @mutates | this
	 * 
	 * @post | getMinutesSinceMidnight() == newMinutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int newMinutesSinceMidnight) {
		this.hours = newMinutesSinceMidnight / 60;
		this.minutes = newMinutesSinceMidnight % 60;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHours() {
		return this.hours;
	}

	public int getMinutes() {
		return this.minutes;
	}
	
	public int getMinutesSinceMidnight() {
		return this.hours * 60 + this.minutes;
	}
	
	/**
     * Returns whether this time is before the given time.
     *
     * @pre Argument {@code other} is not {@code null}.
     *    | other != null
     * @post
     *      The result is {@code true} iff either this object's hours are less
     *      than the given object's hours, or this object's hours equal the
     *      given object's hours and this object's minutes are less than the
     *      given object's minutes.
     *    | result == (
     *    |     getHours() < other.getHours() ||
     *    |     getHours() == other.getHours() &&
     *    |         getMinutes() < other.getMinutes()
     *    | )
     */
    public boolean isBefore(TimeOfDay other) {
        return
            hours < other.hours ||
            hours == other.hours && minutes < other.minutes;
    }

}

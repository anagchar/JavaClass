package exercises;


/**
 * Each instance of this class stores a time of day in hours and minutes.
 * 
 * @invar The hours are between 0 and 23. | 0 <= getHours() && getHours() <= 23
 * @invar The minutes are between 0 and 59. | 0 <= getMinutes() && getMinutes() <= 59
 * 
 */

public class TimeOfDay {
	
	/*
	 * @invar | 0 <= hours && hours <= 23
	 * @invar | 0 <= minutes && minutes <= 59
     */
	private int hours;
	private int minutes;
	
	
	/*
	 * @pre | 0 <= hours && hours <= 23
	 * @pre | 0 <= minutes && minutes <= 59
	 * 
	 * @mutates | this
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
	// Constructor
	public TimeOfDay(int hours, int minutes) {
		if (!(0 <= hours && hours <= 23))
            throw new IllegalArgumentException("hours out of range");
        if (!(0 <= minutes && minutes <= 59))
            throw new IllegalArgumentException("minutes out of range");
		this.hours = hours;
		this.minutes = minutes;
	}
	
	// Getters
	public int getHours() {
		return this.hours;
	}

	public int getMinutes() {
		return this.minutes;
	}
	
	// Setters
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	// Getter the time in minutes since midnight
	public int getMinutesSinceMidnight() {
		return this.hours * 60 + this.minutes;
	}
	
	
	// Setter the time in minutes since midnight
	public void setTime(int minutesSinceMidnight) {
		this.hours = minutesSinceMidnight / 60;
		this.minutes = minutesSinceMidnight % 60;
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

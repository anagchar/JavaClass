package TimeOfDay;

/**
 * @invar Setting the valid boundaries for the hours that a day could have
 * 		 | 23 >= getHours() && getHours() >= 0
 * @invar Setting the valid boundaries for the minutes that a day could have
 * 		 | 59 >= getMinutes() && getMinutes() >= 0
 * @invar The minutes for the midnight are:
 * 		 | getMinutesSinceMidnight() == getHours() * 60 + getMinutes()
 */
public class TimeOfDay {
	
	/**
	 * The fields of the class
	 * @invar | 23 >= hours && hours >= 0
	 * @invar | 59 >= minutes && minutes >= 0
	 */
	private int hours;
	private int minutes;
	
	/**
	 * @invar | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24 * 60
	 */
	private int minutesSinceMidnight;
	
	/**
	 * A getter method that gives the time of the day in hours
	 * 
	 * @inspects | this
	 * 
	 * @post | result <= 23 && result >= 0
	 */
	public int getHours() { 
		return this.hours;
	}
	
	/**
	 * A getter method that gives the time of the day in minutes
	 * 
	 * @inspects | this
	 * 
	 * @post | result <= 59 && result >= 0
	 */
	public int getMinutes() { 
		return this.minutes;
	}
	
	/**
	 * A getter method that gives the minutes that we have until midnight
	 * 
	 * @inspects | this
	 * 
	 * @post | 0 <= result && result < 24 * 60
	 */
	public int getMinutesSinceMidnight() { 
		return this.minutesSinceMidnight;
	}
	
	/**
	 * 	Constructor fo the class
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
	public TimeOfDay (int hours, int minutes) { 
		if (hours < 0 || hours > 23) {
			throw new IllegalArgumentException("The hours is out of the limits");
		}
		if (minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException("The minutes is out of the limits");
		}
		this.hours = hours;
		this.minutes = minutes;
		this.minutesSinceMidnight = hours * 60 + minutes;
	}
	
	/**
	 * 
	 * @pre | 0 <= Newhours && Newhours <= 24
	 * 
	 * @mutates | this
	 * 
	 * @post | getHours() == Newhours
	 * @post | getMinutes() == old(getMinutes())
	 * 
	 */
	public void setHours(int Newhours) { 
		this.hours = Newhours;
		this.minutesSinceMidnight = Newhours * 60 + minutesSinceMidnight % 60;
	}
	
	/**
	 * 
	 * @pre | 0 <= Newminutes && Newminutes <= 59
	 * 
	 * @mutates | this
	 * 
	 * @post | getHours() == old(getHours())
	 * @post | getMinutes() == Newminutes
	 */
	public void setMinutes(int Newminutes) {
		this.minutes = Newminutes;
		this.minutesSinceMidnight = minutesSinceMidnight - minutesSinceMidnight % 60 + minutes;
	}
	
	/**
	 * @pre | 0 <= NewminutesSinceMidnight && NewminutesSinceMidnight < 24 * 60
	 * 
	 * @mutates | this
	 * 
	 * @post | getMinutesSinceMidnight() == NewminutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int NewminutesSinceMidnight) { 
		this.minutesSinceMidnight = NewminutesSinceMidnight;
		this.hours = NewminutesSinceMidnight / 60;
		this.minutes = NewminutesSinceMidnight % 60; 
	}
	

}

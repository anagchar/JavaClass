package interval_oop;

/**
 * Each instance of this class stores an interval of integer line.
 * 
 * @invar This lower bound is not greater than its upper bound.
 *       | getLowerBound() <= getUpperBound()
 * @invar This length equals the upper bound minus the lower bound.
 *      | getLength() == getUpperBound() - getLowerBound()
 * 
 */

public class Interval {
	
	/*
	 * @invar | 0 <= length //talk about the private and that's why we have this separately
	 */
	private int lowerBound;
	private int length;
	
	public int getLowerBound() {
		return this.lowerBound;
	}
	
	public int getUpperBound() {
		return this.lowerBound + this.length;
	}
	
	public int getLength() {
		return this.length;
	}
	
	/**
	 * 
	 * @pre | intialLowerBound <= initialUpperBound
	 * 
	 * @post | getLowerBound() == intialLowerBound
	 * @post | getUpperBound() == initialUpperBound
	 */
	
	public Interval(int intialLowerBound, int initialUpperBound) {
		this.lowerBound = intialLowerBound;
		this.length = initialUpperBound - intialLowerBound;
	}

	/**
	 * 
	 * @pre | newLowerBound <= getUpperBound()
	 * 
	 * @mutates | this
	 * 
	 * @post | getLowerBound() == newLowerBound // no this.LowerBound because it is private and the documentation is public
	 * @post | getLength() == old(getLength())
	 */
	public void setLowerBound(int newLowerBound) {
		this.lowerBound = newLowerBound;
	}
	
	/**
	 * 
	 * @pre | newUpperBound >= getLowerBound()
	 * 
	 * @mutates | this
	 * 
	 * @post | getUpperBound() == newUpperBound
	 * @post | getLength() == old(getLength())
	 */
	public void setUpperBound(Interval interval, int newUpperBound) {
		interval.length = newUpperBound - interval.lowerBound;
	}
	
	
}


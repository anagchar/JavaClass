package Intlist;

import java.util.Arrays;

public class Intlist {

	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * 
	 * @post | result != null
	 */
	public int[] getElements() {
		return elements.clone();
	}
	
	/**
	 * @pre | 0 <= index && index < getElements().length
	 * 
	 * @inspect | this
	 * 
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) {
		return elements[index];
	}
	
	/**
	 * @pre | InitialElements != null
	 * 
	 * @inspects | InitialElements
	 * 
	 * @post | Arrays.equals(getElements(), InitialElements)
	 */
	public Intlist(int[] InitialElements) {
		this.elements = InitialElements.clone();
	}
	
	/**
	 * 
	 * @mutates | this
	 * 
	 * @post | getElements() != old(getElements())
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | Arrays.equals(getElements(), 0, old(getElements().length), old(getElements()), 0, old(getElements().length))
	 */
	public void add(int value) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = value;
	}
	
	/**
	 * @mutates | this
	 * 
	 * @post | getElements() != old(getElements())
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.equals(getElements(), 0, (old(getElements().length)-1), old(getElements()), 0, (old(getElements().length)-1))
	 */
	public void removeLast() {
		elements = Arrays.copyOf(elements, elements.length - 1);
	}
}

package exercises.Intlist;

import java.util.Arrays;

// 1. Define the API
// 	1.1 Write a line of informal documentation for the class, explaining what an instance represents (immutable abstraction)/stores (mutable abstraction).
// 	1.2 Define the raw abstract state space (= declaring the inspectors/getters).
//  1.3 Define the valid abstract state space (= writing down the abstract state invariants),
//  either as @invar clauses in the Javadoc for the class or as @post clauses in the Javadoc for the inspectors)
//  1.4 Define and documenting the constructors and the mutators.

// 2. Implement the API
//     2.1 Define the representation
//     	2.1.1 Define the raw concrete state space (= define the fields)
//     	2.1.2 Define the set of valid concrete states (= write down the representation invariants)
//			(= concrete state invariants, = private class invariants)
//		2.1.3 Define the mapping from valid concrete states to abstract states (= implement the inspectors)
//		2.1.4 Perform sanity checks:
//	    	2.1.4.1 The inspectors must never crash when called in a valid concrete state.
//			2.1.4.2 The inspectors must map 
/**
 * Each instance of this class stores a sequence of int values.
 */
public class Intlist {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	/** Private fields
	 * 
	 * @post | result != null
	 */
	public int[] getElements() {
		return elements.clone();
	}
	
	/**
	 * @post | result == getElements().length
     */
	public int getLength() {
		return elements.length;
	}
	
	/**
	 * @post | 0 <= index && index < getLength()
	 * 
	 * @inspects | this
	 * 
	 * @post | result == getElements()[index]
	 */	
	public int getElementAt(int index) {
		return elements[index];
	}
	
	/**
     * @pre | initialElements != null
     * 
     * @inspects | initialElements
     * 
     * @post | Arrays.equals(getElements(), initialElements)
     */
	public Intlist(int[] initialElements) {
        this.elements = initialElements.clone();
    }
	
	/**
	 * @mutates | this
	 * 
	 * @post | getLength() == old(getLength()) + 1
	 * @post The existing elements are unchanged.
	 * 		 | Arrays.equals(getElements(), 0, old(getLength()), old(getElements()), 0, old(getLength()))
	 * @post | getElementAt(old(getLength())) == element
     */
	public void add(int element) {
		elements = Arrays.copyOf(elements, elements.length + 1);
		elements[elements.length - 1] = element;
	}
	
	/**
	 * @mutates | this
	 * 
	 * @pre | getLength() > 0
	 * 
	 * @post | getLength() == old(getLength()) - 1
	 * @post | Arrays.equals(getElements(), 0, getLength(), old(getElements()), 0, getLength())
     */
	public void removeLast() {
		elements = Arrays.copyOf(elements, elements.length - 1);
	}
}
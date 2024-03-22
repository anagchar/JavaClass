package exercises;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Intlist {
	
	/** Private fields
	 * @invar | 0 <= size && size <= elements.length
	 * @invar | elements != null
	 */
	private int[] elements;
	private int size;
	
	/**
	 * Constructor
	 * @throws IllegalArgumentException | initialelements == null
	 * @throws IllegalArgumentException | initialsize < 0
	 * 
	 * @post | toArray() == initialelements
	 * @post | getSize() == initialsize
	 */
	public Intlist(int[] initialelements, int initialsize) {
		if (initialelements == null)
			throw new IllegalArgumentException("elements is null");
		if (initialsize < 0) {
			throw new IllegalArgumentException("size is negative");
		}
		this.elements = Arrays.copyOf(initialelements, initialsize); // defensive copy in order to avoid aliasing
		this.size = initialsize;
	}
	
	/**
	 * Returns the elements
	 * @return
	 */
	public int[] toArray() {
        return Arrays.copyOf(elements, size); // defensive copy in order to avoid aliasing
    }
	
	/**
	 * Adds a value to the list.
	 * @throws IllegalArgumentException if the index is out of bounds
	 * 		| index < 0 || index > getSize()
	 * @throws IllegalArgumentException if the list is full 
	 * 		| getSize() == getElements().length
	 * 
	 * @mutates | this
	 * 
	 * @post | getSize() == old(getSize())
	 * @post | toArray() == IntStream.concat(Arrays.stream(getElements()), Arrays.stream(new int[] {value})).toArray()
	 */
	public void add(int value, int index) {
		if (index < 0 || index > size)
			throw new IllegalArgumentException("Index out of bounds");
		if (size == elements.length)
			throw new IllegalArgumentException("List is full");
		
		// Shift elements to the right to make space for the new value
		System.arraycopy(elements, index, elements, index + 1, size - index);
		this.elements[index] = value;
		size++;
		
    }
	
	/**
	 * Removes the last element from the list
	 * @throws IllegalArgumentException if the list is empty
	 *         | getSize() == 0
	 */
	public void removeLast() {
		if (size == 0) {
			throw new IllegalArgumentException("List is empty");
		}
		size--;
	}
	
	
	/**
	 * Returns the element at the given index
	 */
	public int[] getElements() {
		return Arrays.copyOf(elements, size);
	}
	
	/**
	 * Returns the size of the list
	 * 
	 * @return | getSize()
	 */
	public int getSize() {
		return this.size;
	}
	

}

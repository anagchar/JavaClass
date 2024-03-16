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
	 * @throws IllegalArgumentException | elements == null
	 * @throws IllegalArgumentException | size < 0
	 * 
	 * @post | toArray() == elements
	 * @post | getSize() == size
	 */
	public Intlist(int[] elements, int size) {
		if (elements == null)
			throw new IllegalArgumentException("elements is null");
		if (size < 0) {
			throw new IllegalArgumentException("size is negative");
		}
		this.elements = Arrays.copyOf(elements, elements.length); // defensive copy in order to avoid aliasing
		this.size = size;
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
	 * @throws IllegalArgumentException if the list is full 
	 * 		| getSize() == getElements().length
	 * 
	 * @mutates | this
	 * 
	 * @post | getSize() == old(getSize())
	 * @post | toArray() == IntStream.concat(Arrays.stream(getElements()), Arrays.stream(new int[] {value})).toArray()
	 */
	public void add(int value, int index) {
		if (size == elements.length) {
			throw new IllegalArgumentException("List is full");
		}
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

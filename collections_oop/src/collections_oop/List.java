package collections_oop;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface List {
	
	
	/**
	 * @inspects | this // because here the getters method differ so we use the inspect keyword because the default is to be assigned as mutators
	 * @post | result != null
	 * @post | Arrays.stream(result).allMatch(e -> e != null)
	 * 
	 * @creates | result
	 * 
	 */
	Object[] toArray(); // returns an array of objects that are stored in the list
	
	default Stream<Object> stream() {
        return Arrays.stream(toArray());
    }
	
	/**
	 * @inspects | this
	 * @post | result == toArray().length
     */
	int size(); // public and abstract are the defaults in an interface
	
	/**
	 * @inspects | this
	 * @pre | 0 <= index && index < size()
	 * 
	 * @post | result == toArray()[index]
	 */
	Object get(int index); // returns the object stored in the list at a given
	
	/**
	 * Returns the index of the first occurence of the given object in this list or -1 if the object is not in the list.
	 * The given object is compared to the elements of the list using the Object.equals method.
	 * @inspects | this
	 * @pre | object != null
	 * 
	 * @post | IntStream.range(0, size()).filter(i -> toArray()[i].equals(object)).findFirst().orElse(-1) == result
	 */
	int indexOf(Object object); // returns the index of the object in the list
	
	/**
	 * Returns whether the given object is in this list. The given object is
	 * compared to the elements of the list using the Object.equals method.
	 * 
	 * @inspects | this
	 * @pre | object != null
	 * 
	 * //@post | Arrays.stream(toArray()).anyMatch(e -> e.equals(object)) == result
	 * @post | result == (indexOf(object) != -1)
	 */
	public default boolean contains(Object object) { return indexOf(object) != -1; } // returns true if the list contains the object
	
	/**
	 * Adds the given object to the index of the list.
	 * 
	 * @pre | object != null
	 * @pre | 0 <= index
	 * @pre | index <= size()
	 * 
	 * @mutates | this
	 * @post | size() == old(size()) + 1
	 * @post | get(index) == object
	 * @post | Arrays.equals(toArray(), 0, index, old(toArray()), 0, index)
	 * @post | Arrays.equals(toArray(), index + 1, size(), old(toArray()), index, old(size()))	
     */
	void add(int index, Object object); // adds the object to the list at a given index
	
	/**
	 * Adds the given object to the end of the list.
	 * 
	 * @pre | object != null
	 * @mutates | this
	 * @post | size() == old(size()) + 1
	 * @post | get(old(size())) == object
	 * @post | Arrays.equals(toArray(), 0, old(size()), old(toArray()), 0, old(size()))
	 */
	default void add(Object object) {
		add(size(), object);
	} // adds the object to the end of the list
	
	/**
	 * Removes the object at the given index from the list.
	 * 
	 * @pre | 0 <= index
	 * @pre | index < size()
	 * 
	 * @mutates | this
	 * @post | size() == old(size()) - 1
	 * @post | Arrays.equals(toArray(), 0, index, old(toArray()), 0, index)
	 * @post | Arrays.equals(toArray(), index, size(), old(toArray()), index + 1, old(size()))
	 */
	void remove(int index); // removes the object at the given index
	
	/**
	 * @pre | object != null
	 * @mutates | this
	 * 
	 * @post | Arrays.equals(toArray(), IntStream.range(0, size()).filter(i -> i != indexOf(object)).mapToObj(i -> get(i)).toArray())
	 */
	default void remove(Object object) {
		int index = indexOf(object);
		if (index != -1)
			remove(index);
	} // removes the object from the list)

}

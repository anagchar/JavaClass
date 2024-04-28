package collections_oop;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @invar The set does not contain duplicates.
 * 		| stream().distinct().count() == size()
 */
public interface Set {
	
	/**
	 * @inspects | this
	 * @post | result != null
	 * @post | Arrays.stream(result).allMatch(e -> e != null)
	 * @creates | result
	 */
	Object[] toArray();
	
	default Stream<Object> stream() {return Arrays.stream(toArray());};
	
	/**
	 * @inspects | this
	 * @post | result == toArray().length
	 */
	int size();
	
	/**
	 * @inspects | this
	 * @pre | object != null
	 * @post | result == stream().anyMatch(e -> e.equals(object))
     */
	boolean contains(Object object);
	
	/**
	 * @pre | object != null
	 * @mutates | this
	 * @post | contains(object)
	 * @post | Arrays.stream(old(toArray())).allMatch(e -> contains(e))
	 * @post | stream().allMatch(e -> Arrays.stream(old(toArray())).anyMatch(e1 -> e1.equals(e)) || object.equals(e))
	 */
	public void add(Object object);
	
	/**
	 * @pre | object != null
	 * @mutates | this
	 * @post | Arrays.stream(old(toArray())).allMatch(e -> object.equals(e) || contains(e)) // lower bound (all elements that were in the set before are still in the set)
	 * @post | stream().allMatch(e -> !object.equals(e) && Arrays.stream(old(toArray())).anyMatch(e1 -> e1.equals(e))) // upper bound (no new elements are added and the object is removed)
	 */
	public void remove(Object object);

}

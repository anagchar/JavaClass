package Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.util.Elements;

/**
 * @invar | toArray() != null
 * @invar | Arrays.stream(toArray()).allMatch(element -> element != null)
 * 
 */
abstract public class Queue {
	
	ArrayList<Object> elements;
		
	/**
	 * @inspects | this
	 * @post | result == toArray().length
	 */
	public abstract int getSize();
	
	/**
	 * @creates | result
	 * @ispects | this
	 */
	public abstract Object[] toArray();
	
	/**
	 * @mutates | this
	 * 
	 * @throws IllegalArgumentException | element == null
	 * 
	 * @post | getSize() == old(getSize()) + 1
	 * @post | Arrays.equals(toArray(), 0, old(getSize()), old(toArray()), 0, old(getSize()))
	 * @post | toArray()[old(getSize())] == element 
	 */
	public abstract void enqueue(Object element);
	
	/**
	 * @mutates | this
	 * @post | old(getSize()) == getSize() + 1
	 * @post | Arrays.equals(toArray(), 0, getSize(), old(toArray()), 1, old(getSize()))
	 */
	public abstract Object dequeue();

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Queue q && Arrays.equals(q.toArray(), this.toArray());
	}
}

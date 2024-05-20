package collections_oop;

import java.util.stream.IntStream;

public class RingBuffer implements List {
	
	/**
	 * @representationObject
	 * @invar | elements != null
	 * @invar | 0 <= size && size <= elements.length
	 * @invar | start < elements.length
	 * @invar | IntStream.range(0, size).allMatch(i -> elements[(start + i) % size] != null)
	 * @invar | IntStream.range(size, elements.length).allMatch(i -> elements[(start +i) % elements.length] == null)
	 * 
     */
	private Object[] elements;
	private int size;
	private int start;

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		for (int i = 0; i < size; i++) {
			result[i] = elements[(start + i) % elements.length];
		}
		return result;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Object get(int index) {
		return elements[(start + index) % elements.length];
	}
	
	@Override
	public boolean contains(Object value) {
		for (int i = 0; i < size; i ++) {
			if (get(i).equals(value))
				return true;
		}
		return false;
	}
	
	/**
	 * @post | size() == 0
	 */
	public RingBuffer() {
		elements = new Object[10];
	}
}

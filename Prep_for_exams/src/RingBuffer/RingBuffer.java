package RingBuffer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RingBuffer implements List {
	
	/**
	 * @invar | size >= 0 && size <= elements.length
	 * @invar | 1 <= elements.length
	 * @invar | start >= 0
	 * @invar | start < elements.length
	 * @invar | elements != null
	 * @invar | IntStream.range(0, size).allMatch(i -> elements[(start + i) % elements.length] != null)
	 * @invar | IntStream.range(size, elements.length).allMatch(i -> elements[(start + i) % elements.length] == null)
	 * 
	 * @representationObject
	 */
	private Object[] elements;
	private int size;
	private int start;
	
	public RingBuffer(){
		this.elements = new Object[10];
	}
	
	@Override
	public int size() {
		return size;
	}
		
	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		for (int i = 0; i < size; i++) {
			result[i] = elements[(start + i) % elements.length];
		}
		return result;
	}
	
	/**
	 * @throws IllegalArgumentException if the index has size out of the boundaries
	 * 
	 * @inspects | this
	 * 
	 */
	@Override
	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("The index could not be less than 0 or more than the size of the RingBuffer");
		}
		index = (this.start + index) % elements.length;
		return elements[index];
	}
	
	@Override
	public boolean contains(Object value) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(value))
				return true;
		} return false;
	}
	
	@Override
	public void add(int index, Object value) {
		if (size == elements.length) {
			Object[] newElements = new Object[size * 2];
			for (int i = 0; i < size; i++) {
				newElements[i] = get(i);
			}
			elements = newElements;
			start = 0;
		}
		if (index < size / 2) {
			start = (start + elements.length - 1) % elements.length;
			for (int i = 0; i < index; i++) {
				elements[Math.floorMod(start + i - 1, elements.length)] = 
						elements[(start + i + 1) % elements.length];
			}
		} else {
			for (int i = size - 1; index <= i; i--) {
				elements[(start + i) % elements.length] = elements[(start + i) % elements.length];
			}
		}
		elements[(start + index) % elements.length] = value;
		size++;	
	}
	
	@Override
	public void remove(int index) {
		if (index < size / 2) {
			for (int i = index - 1; 0 <= i; i--)
				elements[(start + i + 1) % elements.length] =
					elements[(start + i) % elements.length];
			elements[start] = null;
			start = (start + 1) % elements.length;
		} else {
			for (int i = index; i < size - 1; i++)
			elements[(start + i) % elements.length] =
				elements[(start + i + 1) % elements.length];
			elements[(start + size - 1) % elements.length] = null;
		}
		size--;
	}

	@Override
	public void remove(Object value) {
		// TODO Auto-generated method stub
		
	}
	
	

}

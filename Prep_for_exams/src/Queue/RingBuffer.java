package Queue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RingBuffer extends Queue {
	
	/**
	 * @invar | elements != null
	 * @invar | size <= elements.length
	 * @invar | start < elements.length
//	 * @invar | IntStream.range(0, elements.length).allMatch(e -> elements[(start + e) % elements.length] == null || elements[(start + e) % elements.length] == this)
	 * 
	 * @representationObject
	 */
	private Object[] elements = new Object[3];
	private int start = 0;
	private int size = 0;
	
	
	public RingBuffer() {}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		if (start + size <= elements.length) {
			System.arraycopy(elements, start, result, 0, size);
		} else {
			int firstPart = elements.length - start;
			System.arraycopy(elements, start, result, 0, firstPart);
			System.arraycopy(elements, 0, result, firstPart, size - firstPart);
		}
		return result;
	}

	@Override
	public void enqueue(Object element) {
		if (element == null) {
			throw new IllegalArgumentException("The element cannot be null!");
		}
		if (size == elements.length) {
			elements = Arrays.copyOf(toArray(), size*2);
			start = 0;
		}
		elements[(start + size++) % elements.length] = element;
		
	}

	@Override
	public Object dequeue() {
		Object result = elements[start];
		elements[start] = null;
		start = (start + 1) % elements.length;
		size--;
		return result;
	}
	
	
	

}

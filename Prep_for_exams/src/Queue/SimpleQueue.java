package Queue;

import java.util.ArrayList;

import javax.sound.midi.Sequence;

public class SimpleQueue extends Queue {
	
	/**
	 * @invar | elements != null
	 * @invar | elements.stream().allMatch(element -> element != null)
	 * 
	 * @representationObject
	 */
	private ArrayList<Object> elements = new ArrayList();
	
	public int getSize() {
		return elements.size();
	}

	public Object[] toArray() {
		return elements.toArray();
	}
	
	/**
	 * @post | getSize() != 0
	 */
	public SimpleQueue() {};
	
	public void enqueue(Object element){
		if (element == null) {
			throw new IllegalArgumentException("The element cannot be null.");
		}
		elements.add(element);
	}
	
	public Object dequeue() {
		return elements.removeFirst();
	}
 	
	
	
	
	
	

}

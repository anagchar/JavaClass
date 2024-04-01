package exercises;

import java.util.Arrays;

public class IntlistNodes {
	
	private class Node {
		int value;
		Node next;
		
		Node (int value, Node next) {
	        this.value = value;
	        this.next = next;
	    }
	}
	
	private Node first; // this is a field of the inner class and this field is a pointer to a node object (Node next)
	private int getLengthPrivate() {
		int result = 0;
		for (Node n = first; n != null; n = n.next) {
			result++;
		}
		return result;
	}
	
	/** Private fields
	 * 
	 * @post | result != null
	 */
	public int[] getElements() {
		int result[] = new int[getLength()];
		int i = 0;
		for (Node n = first; n != null; n = n.next) {
			result[i] = n.value;
			i++;
		}
		return result;
	}
	
	/**
	 * @post | result == getElements().length
     */
	public int getLength() {
		return getLengthPrivate();
	}
	
	/**
	 * @post | 0 <= index && index < getLength()
	 * 
	 * @inspects | this
	 * 
	 * @post | result == getElements()[index]
	 */	
	public int getElementAt(int index) {
		Node n = first;
		for (; index > 0; n = n.next) {
			index--;
		}
		return n.value;
	}
	
	/**
     * @pre | initialElements != null
     * 
     * @inspects | initialElements
     * 
     * @post | Arrays.equals(getElements(), initialElements)
     */
	public IntlistNodes(int[] initialElements) {
        Node n = null;
        for (int i = initialElements.length - 1; i >= 0; i--) {
        	n = new Node(initialElements[i], n);}
        first = n;
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
		if (first == null) {
			first = new Node(element, null);
		} else {
			Node n = first;
			while (n.next != null) {
				n = n.next;
			}
			n.next = new Node(element, null);
		}
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
		Node n = first;
		while (n.next.next != null) {
			n = n.next;
		}
		n.next = null;
	}

}

package exercises.Sequence;

import java.util.Objects;

public class NonEmptySequence extends Sequences {
	private final int head;
	private final Sequences tail; // with the "final" you make the tail an immutable object
	
	public int getHead() { return head; }
	
	public Sequences getTail() { return tail; }
    
    NonEmptySequence(int head, Sequences tail){
        this.head = head;
        this.tail = tail;
    }
    
    @Override
    public int getLength() {
    	return 1 + tail.getLength();
    	}
    
    @Override
    public String toString() {
    	return "[" + head + toStringTail(tail) + "]";
    }
    
    private String toStringTail(Sequences tail) {
        if (tail instanceof EmptySequence) {
            return "";
        } else if (tail instanceof NonEmptySequence) {
            NonEmptySequence nonEmptyTail = (NonEmptySequence) tail;
            return ", " + nonEmptyTail.head + toStringTail(nonEmptyTail.tail);
        }
        return ""; // fallback, should not reach here if all cases are handled
    }
    
    @Override
    public boolean equals(Object obj) {
    	return obj instanceof NonEmptySequence n 
    			&& head == n.head 
    			&& tail.equals(n.tail);
    }
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return Objects.hash(super.hashCode(), head + super.hashCode(), tail);
    }
    
    }

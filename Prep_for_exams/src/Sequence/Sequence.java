package Sequence;

sealed abstract class Sequence permits NonEmptySequence, EmptySequence {

	public abstract int getLength();
}

final class NonEmptySequence extends Sequence {
	
	private final int head;
	private final Sequence tail;
	
	public NonEmptySequence(int head, Sequence tail) {
		this.head = head;
		this.tail = tail;
	}
	
	int getHead() {
		return this.head;
	}
	
	Sequence getTail() {
		return this.tail;
	}
	
	@Override
	public int getLength() {
		return 1 + tail.getLength();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NonEmptySequence seq && 
				seq.getHead() == this.head &&
				this.tail.equals(seq.tail);
	}
	
	@Override
	public String toString() {
		return "[" + head + (tail instanceof EmptySequence ? "]" : ", " + tail.toString().substring(1) + "]");
	}
}

final class EmptySequence extends Sequence {
	
	@Override
	public int getLength() {
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof EmptySequence;
	}
	
	@Override
	public String toString() {
	    return "[]";
	}
	
	
}

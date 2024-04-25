package exercises;

abstract sealed class Sequences permits EmptySequence, NonEmptySequence {
	
	public abstract int getLength(); 
	

	public abstract String toString();

	
	public static void main(String[] args) {
		Sequences O = new NonEmptySequence(1, new NonEmptySequence(5, new NonEmptySequence(9, new EmptySequence())));
		System.out.println(O);
	}
}

final class EmptySequence extends Sequences {
	
	@Override
    public int getLength() {
        return 0;
    }
	
	@Override
	public String toString() {
	    return "[]";
	}

	
	}

final class NonEmptySequence extends Sequences {
	int head;
	Sequences tail;
    
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
    
    }





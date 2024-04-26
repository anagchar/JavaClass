package exercises.Sequence;

public class EmptySequence extends Sequences {
	
	@Override
    public int getLength() {
        return 0;
    }
	
	@Override
	public String toString() {
	    return "[]";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof EmptySequence;
	}
	
	}

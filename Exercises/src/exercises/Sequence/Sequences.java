package exercises.Sequence;

public abstract class Sequences {
	
	public abstract int getLength(); 
	

	public abstract String toString();

	
	public static void main(String[] args) {
		Sequences O = new NonEmptySequence(1, new NonEmptySequence(5, new NonEmptySequence(9, new EmptySequence())));
		System.out.println(O);
		Sequences bb = new NonEmptySequence(1, new NonEmptySequence(5, new EmptySequence()));
		System.out.println(((NonEmptySequence) bb).getTail());

	}
}





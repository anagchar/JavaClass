package exercises;

abstract sealed class IntSequence permits EmptySequence, NonEmptySequence {};

final class EmptySequence extends IntSequence {
	}

final class NonEmptySequence extends IntSequence {
	int head;
    IntSequence tail;
    
    NonEmptySequence(int head, IntSequence tail){
        this.head = head;
        this.tail = tail;
    }
}

public class Sequences {

}

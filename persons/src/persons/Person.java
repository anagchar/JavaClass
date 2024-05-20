package persons;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import logicalcollections.LogicalSet;

/**
 * Each instance of this class represents a person in a graph of father-child relations.
 * 
 * @invar The bidirectional association is consistent, in the father -> children direction.
 * 		| getChildren().stream().allMatch(child -> child != null && child.getFather() == this)
 * @invar The bidirectional association is consistent, in the children -> father direction.
 *      | getFather() == null || getFather().getChildren().contains(this)
 */
public class Person {
	
	/**
	 * @invar | children != null
	 * @invar | children.stream().allMatch(child -> child != null && child.father == this)
	 * @invar | father == null || father.children.contains(this)
	 * 
	 * @peerObject
	 */
	private Person father;
	
	/**
	 * @representationObject \\ because the content of the Set object is also part of the state of the Person
	 * @peerObjects
	 */
	private Set<Person> children;
	
	/**
	 * @peerObject
	 */
	public Person getFather() {
		return father;
	}
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 * @post | result.stream().allMatch(child -> child != null)
	 */
	public Set<Person> getChildren() {
		return Set.copyOf(children);
	}
	
	/**
	 * @post | getFather() == null
	 * @post | getChildren().isEmpty()
	 * 
	 */
	public Person() {
		children = new HashSet<>();
	}
	
	/**
	 * @pre | getFather() == null
	 * @pre | father != null
	 * @mutates | this, father
	 * @mutates_properties | this.getFather(), father.getChildren()
	 * @post | getFather() == father
	 * @post "father"'s set of childer equals their old set of children plus "this".
	 * 		//| father.getChildren().equals(LogicalSet.plus(old(father.getChildren()), this))
	 * @post Another option instead the above but is not recommended.
	 * 		| father.getChildren().equals(Stream.concat(old(father.getChildren()).stream(), Stream.of(this)).collect(Collectors.toSet()))
	 */
	public void setFather(Person father) {
		this.father = father;
		father.children.add(this);
	}
	
	/**
	 * @pre | getFather() != null
	 * @mutates_properties | getFather(), getFather().getChildren() // evaluated in the pre state
	 * @post | getFather() == null
	 * //@post | old(getFather()).getChildren().equals(LogicalSet.minus(old(getFather().getChildren()), this))
	 */
	public void clearFather() {
		father.children.remove(this);
		father = null;
	}

}

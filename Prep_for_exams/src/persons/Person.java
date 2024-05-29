package persons;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getFather() == null || getFather().getChildren().contains(this)
 * @invar | getChildren().stream().allMatch(child -> child != null && child.getFather() == this)
 */
public class Person {
	
	/**
	 * @peerObject
	 * @invar | father == null || father.children.contains(this)
	 */
	private Person father;
	
	/**
	 * @peerObjects
	 * @representationObjects
	 * @invar | children != null
	 * @invar | children.stream().allMatch(child -> child != null && child.father == this)
	 */
	private Set<Person> children;
	
	/**
	 * @post | getFather() == null
	 * @post | getChildren().isEmpty()
	 */
	public Person() {
		this.children = new HashSet<>();
	}
	
	/**
	 * @pre | father != null
	 * @pre | getFather() == null
	 * @mutates | this, father
	 * @mutates_properties | father.getChildren(), this.getFather()
	 * @post | getFather() == father
	 * @post "father"'s set of childern equals their old set of children plus "this".
	 * 		 | father.getChildren().equals(LogicalSet.plus(old(father.getChildren()), this)) 
	 */
	public void setFather(Person father) { 
		if (this.father != null) {
			this.removeFather();
		}
		this.father = father;
		father.children.add(this); // Bidirectional association
	}
	
	
	/**
	 * @pre | getFather() != null
	 * @mutates_properties | this.getFather(), this.getFather().getChildren()
	 * @post | getFather() == null
	 * @post "father"'s set of childern equals their old set of children minus "this".
	 * 		| old(getFather()).getChildren().equals(LogicalSet.minus(old(getFather().getChildren()), this)) 
	 */
	public void removeFather() { 
		father.children.remove(this);
		this.father = null;
	}
	
	/**
	 * @peerObject
	 * @inspects | this
	 */
	public Person getFather() { 
		return this.father;
	}
	
	/**
	 * @peerObjects
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(child -> child != null)
	 */
	public Set<Person> getChildren() { 
		return Set.copyOf(children);
	}

}

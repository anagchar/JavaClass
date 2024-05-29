package persons;

import java.util.HashSet;
import java.util.Set;

public class Person {
	
	private Person father;
	private Set<Person> children;
	
	public Person() {
		this.children = new HashSet<>();
	}
	
	/**
	 * @pre | father != null
	 * @mutates_properties | father.getChildren(), this.getFather()
	 */
	public void setFather(Person father) { 
		if (this.father != null) {
			this.removeFather();
		}
		this.father = father;
		father.children.add(this); // Bidirectional association
	}
	
	public void removeFather() { 
		this.father = null;
		father.children.remove(this);
	}
	
	public Person getFather() { 
		return this.father;
	}
	
	public Set<Person> getChildren() { 
		return Set.copyOf(children);
	}

}

package Entity;

import logicalcollections.*;

public class Company extends Entity {
	
	/**
	 * @invar | owner != null
	 * @invar | owner.companies.contains(this)
	 * 
	 * @representationObject
	 * @peerObject
	 */
	Entity owner;
	
	/** 
	 * 
	 * @peerObject
	 */
	public Entity getOwner() {
		return owner;
	}
	
	/**
	 * @pre | owner != null
	 * @mutates_properties | owner.getOwnedCompanies()
	 * @post | getOwner() == owner
	 * @post | owner.getOwnedCompanies().equals(LogicalSet.plus(old(owner.getOwnedCompanies()), this))
	 * 
	 */
	public Company (Entity owner) {
		this.owner = owner;
		owner.companies.add(this);
	}
	
	/**
	 * @throws IllegalArgumentException | newOwner == null || newOwner == this
	 * 
	 * @mutates_properties | newOwner.getOwnedCompanies(), getOwner(), getOwner().getOwnedCompanies()
	 * @post | getOwner() == newOwner
	 * @post | old(getOwner()).getOwnedCompanies().equals(LogicalSet.plus(old(newOwner.getOwnedCompanies()), this))
	 * 
	 */
	public void transferTo(Entity newOwner) {
		if (newOwner == null) {
			throw new IllegalArgumentException("The new owner has to be non null!");
		}
		if (owner.companies == newOwner) {
			throw new IllegalArgumentException("The new owner has to be different from the old one!");
		}
		this.owner.companies.remove(this);
		this.owner = newOwner;
		newOwner.companies.add(this);
	}

}

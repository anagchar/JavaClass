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
	
	public Entity getUltimateOwner() {
		Entity ultiOwner = this.owner;
		while (!(ultiOwner instanceof Person))  {
			 ultiOwner = ((Company) owner).owner;
		}
		return ((Person) ultiOwner);
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
	 * @post | getOwner().getOwnedCompanies().equals(LogicalSet.plus(old(getOwner().getOwnedCompanies()), this))
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

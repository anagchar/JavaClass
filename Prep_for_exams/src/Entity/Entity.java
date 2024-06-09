package Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getOwnedCompanies() != null
 * @invar | getOwnedCompanies().stream().allMatch(company -> company != null && company.getOwner() == this)
 */
public abstract class Entity {
	
	/**
	 * @invar | companies != null
	 * @invar | companies.stream().allMatch(company -> company != null && company.getOwner() == this)
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Company> companies = new HashSet<>();
	
	/** 
	 * @creates | this
	 * @post | result != null
	 * 
	 */
	public Set<Company> getOwnedCompanies(){
		return Set.copyOf(companies);
	}
	
	Entity(){}


}

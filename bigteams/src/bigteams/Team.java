package bigteams;

import java.util.HashSet;
import java.util.Set;

/**
 * Each instance of this class respresents a team
 * in a student-team graph.
 * 
 * @invar | getMembers().stream().allMatch(student -> 
 * 		  | 	student.getTeam() == this)
 */
public class Team {
	
	/**
	 * @invar | members != null
	 * @invar | members.stream().allMatch(s -> s != null
	 * 		  |  && s.team == this)
	 * @representationObject
	 * @peerObjects
	 */
	 Set<Student> members = new HashSet<>();
	
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 * @post | result.stream().allMatch(student -> student != null)
	 */
	public Set<Student> getMembers() { return Set.copyOf(members); }

	/**
	 * @post | getMembers().isEmpty()
	 */
	public Team() {}
}

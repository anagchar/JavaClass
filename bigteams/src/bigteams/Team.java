package bigteams;

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
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Student> getMembers() { throw new RuntimeException("Not yet implemented");}

}

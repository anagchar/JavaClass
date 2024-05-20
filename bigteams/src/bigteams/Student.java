package bigteams;

/**
 * Each instance of this class respresents a student
 * in a student-team graph.
 * 
 * @invar | getTeam() == null ||
 * 		  | getTeam().getMembers().contains(this)
 */
public class Student {
	
	/**
	 * @peerObject
	 */
	public Team getTeam() { throw new RuntimeException("Not yet implemented");}

}

package students;


/**
 * Each instance of this class represents a student in a student collaboration graph.
 * 
 * @invar The biderictional association between a Student and the teammate object is consistent.
 *         | getTeammate() == null || getTeammate().getTeammate() == this
 */
public class Student {
	
	/**
	 * @invar The biderictional association between a Student and the teammate object is consistent. 
	 * 		| teammate == null || teammate.teammate == this
	 * @peerObject
	 */
	private Student teammate;
	
	/**
	 * @peerObject
	 */
	public Student getTeammate() {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * @post | getTeammate() == null
	 */
	public Student() {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * @pre | getTeammate() != null
	 * @pre | other.getTeammate() == null
	 * @pre | other != null
	 * @mutates | this, other
	 * @post | getTeammate() == other
	 */
	public void setTeammate(Student other) {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * @pre | getTeammate() != null
	 * @mutates | this
	 * @post | getTeammate() == null
	 * @post | old(getTeammate()).getTeammate() == null
	 */
	public void clearTeammate() {
		throw new RuntimeException("Not yet implemented");
	}

}

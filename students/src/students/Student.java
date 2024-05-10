package students;


/**
 * Each instance of this class represents a student in a student collaboration graph.
 * 
 * @invar The biderictional association between a Student and the teammate object is consistent.
 *         | getTeammate() == null || getTeammate().getTeammate() == this
 */
public class Student {
	
	public Student getTeammate() {
		throw new RuntimeException("Not yet implemented");
	}

}

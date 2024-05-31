package rooms_and_exams;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getExams().stream().allMatch(exam -> exam != null && exam.getRooms().contains(this))
 * @invar | getExams() != null
 */
public class Room {
	
	/**
	 * @invar | exams.stream().allMatch(exam -> exam != null && exam.getRooms().contains(this))
	 * @peerObjects
	 */
	 Set<Exam> exams;
	
	/**
	 * @creates | result
	 * @post | result != null
	 * 
	 */
	public Set<Exam> getExams() { 
		return Set.copyOf(exams);
	}
	
	/**
	 * @pre | exam != null
	 * @pre | getExams() != null
	 * @mutates_properties | this.getExams(), exam.getRooms()
	 * @post | exam.getRooms().equals(LogicalSet.plus(old(exam.getRooms()), this)) 
	 */
	public void addExam(Exam exam) { 
		exams.add(exam);
		exam.rooms.add(this);
	}
	
	/**
	 * @pre | getExams() != null
	 * @pre | exam != null
	 * @mutates_properties | this.getExams(), exam.getRooms()
	 * @post | exam.getRooms().equals(LogicalSet.minus(old(exam.getRooms()), this)) 
	 */
	public void removeExam(Exam exam) { 
		exams.remove(exam);
		exam.rooms.remove(this);
	}
	
	/**
	 * @post | getExams().isEmpty()
	 */
	public Room() {
		this.exams = new HashSet<>();
	}

}

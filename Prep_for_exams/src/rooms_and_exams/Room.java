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
	 * @invar | room != null
	 * @invar | exams.stream().allMatch(exam -> exam != null && exam.getRooms().contains(this))
	 */
	private Room room;
	
	/**
	 * @peerObjects
	 */
	private Set<Exam> exams;
	
	/**
	 * @creates | result
	 * @post | result != null
	 * 
	 */
	public Set<Exam> getExams() { 
		return new HashSet<>(exams);
	}
	
	/**
	 * @pre | exam != null
	 * @pre | getExams() != null
	 * @mutates_properties | this.getExams(), exam.getRooms()
	 * @post | exam.getRooms().equals(LogicalSet.plus(old(exam.getRooms()), this)) 
	 */
	public Set<Exam> addExam(Exam exam) { 
		if (exams.contains(exam)) {
			return new HashSet<>(exams);
		} else {
			exams.add(exam);
			exam.addRoom(this);
			return new HashSet<>(exams);
		}
	}
	
	/**
	 * @pre | getExams() != null
	 * @pre | exam != null
	 * @mutates_properties | this.getExams(), exam.getRooms()
	 * @post | exam.getRooms().equals(LogicalSet.minus(old(exam.getRooms()), this)) 
	 */
	public Set<Exam> removeExam(Exam exam) { 
		if (exams.contains(exam)) {
			exams.remove(exam);
			exam.removeRoom(this);
			return new HashSet<>(exams);
		}
		return new HashSet<>(null);
	}
	
	/**
	 * @pre | name != null
	 * @creates | this
	 */
	public Room(String name) { 
		name = room.toString();
		this.exams = new HashSet<>();
	}
	
	/**
	 * @inspects | this
	 * @post | result != null
	 */
	public Room getRoom() { 
		return this.room;
	}

}

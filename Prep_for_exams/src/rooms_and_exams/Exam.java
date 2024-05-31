package rooms_and_exams;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getRooms().stream().allMatch(room -> room != null && room.getExams().contains(this))
 * @invar | getRooms() != null
 */
public class Exam {
	
	/**
	 * @invar | exam != null
	 * @invar | rooms.stream().allMatch(room -> room != null && room.getExams().contains(this))
	 */
	private Exam exam;
	/**
	 * 
	 * @peerObjects
	 */
	private Set<Room> rooms;
	
	/**
	 * @creates | result
	 * @post | result != null
	 * 
	 */
	public Set<Room> getRooms() { 
		return new HashSet<>(rooms); // to avoid representation exposure
	}
	
	/**
	 * @pre | getRooms() != null
	 * @pre | room != null
	 * @mutates_properties | this.getRooms(), room.getExams() 
	 * @post | room.getExams().equals(LogicalSet.plus(old(room.getExams()), this))
	 */
	public Set<Room> addRoom(Room room) {
		if (rooms.contains(room)) {
			return new HashSet<>(rooms);
		} else {
			rooms.add(room);
			room.addExam(this);
			return new HashSet<>(rooms);
		}
	}
	
	/**
	 * @pre | getRooms() != null
	 * @pre | room != null
	 * @mutates_properties | this.getRooms(), room.getExams()
	 * @post | room.getExams().equals(LogicalSet.minus(old(room.getExams()), this))
	 */
	public Set<Room> removeRoom(Room room) { 
		if (rooms.contains(room)) {
			rooms.remove(room);
			room.removeExam(this);
			return new HashSet<>(rooms);
		}
		return new HashSet<>(null);
	}
	
	/**
	 * @pre | name != null
	 * @creates | this
	 */
	public Exam(String name) { 
		name = exam.toString();
		this.rooms = new HashSet<>();
	}
	
	/**
	 * @post | result != null
	 * @inspects | this
	 */
	public Exam getExam() { 
		return this.exam;
	}

}

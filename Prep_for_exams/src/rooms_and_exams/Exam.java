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
	 * @invar | rooms.stream().allMatch(room -> room != null && room.getExams().contains(this))
	 * @representationObject
	 * @peerObjects
	 */
	Set<Room> rooms = new HashSet<>();
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(room -> room != null && room.getExams().contains(this))
	 * @peerObjects
	 * 
	 */
	public Set<Room> getRooms() { 
		return Set.copyOf(rooms); // to avoid representation exposure
	}
	
	/**
	 * @pre | getRooms() != null
	 * @pre | room != null
	 * @mutates_properties | this.getRooms(), room.getExams() 
	 * @post | room.getExams().equals(LogicalSet.plus(old(room.getExams()), this))
	 */
	public void addRoom(Room room) {
		rooms.add(room);
		room.exams.add(this);
	}
	
	/**
	 * @pre | getRooms() != null
	 * @pre | room != null
	 * @mutates_properties | this.getRooms(), room.getExams()
	 * @post | room.getExams().equals(LogicalSet.minus(old(room.getExams()), this))
	 */
	public void removeRoom(Room room) {
		rooms.remove(room);
		room.exams.remove(this);
	}
	
	/**
	 * @post | getRooms().isEmpty()
	 */
	public Exam() {
		this.rooms = new HashSet<>();
	}
	

}

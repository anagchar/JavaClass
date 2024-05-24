package exams_and_rooms;

import java.util.Set;


/**
 * 
 * 
 * @invar | getRooms().stream().allMatch(room -> room != null && room.getExams().contains(this))
 */
public class Exam {
	
	/**
	 * @creates | result
	 * @peerObjects
	 * @post | result != null
	 */
	public Set<Room> getRooms() { throw new RuntimeException("Not implemented yet."); }
}

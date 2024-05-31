package rooms_and_exams;

import java.util.HashSet;
import java.util.Set;

public class Exam {
	
	private Exam exam;
	private Set<Room> rooms;
	
	public Set<Room> getRooms() { 
		return new HashSet<>(rooms); // to avoid representation exposure
	}
	
	public Set<Room> addRoom(Room room) { 
		if (rooms.contains(room)) {
			return new HashSet<>(rooms);
		} else {
			rooms.add(room);
			room.addExam(this);
			return new HashSet<>(rooms);
		}
	}
	
	public Set<Room> removeRoom(Room room) { 
		if (rooms.contains(room)) {
			rooms.remove(room);
			room.removeExam(this);
			return new HashSet<>(rooms);
		}
		return new HashSet<>(null);
	}
	
	public Exam(String name) { 
		name = exam.toString();
		this.rooms = new HashSet<>();
	}
	
	public Exam getExam() { 
		return this.exam;
	}

}

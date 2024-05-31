package rooms_and_exams;

import java.util.HashSet;
import java.util.Set;

public class Room {
	
	private Room room;
	private Set<Exam> exams;
	
	public Set<Exam> getExams() { 
		return new HashSet<>(exams);
	}
	
	public Set<Exam> addExam(Exam exam) { 
		if (exams.contains(exam)) {
			return new HashSet<>(exams);
		} else {
			exams.add(exam);
			exam.addRoom(this);
			return new HashSet<>(exams);
		}
	}
	
	public Set<Exam> removeExam(Exam exam) { 
		if (exams.contains(exam)) {
			exams.remove(exam);
			exam.removeRoom(this);
			return new HashSet<>(exams);
		}
		return new HashSet<>(null);
	}
	
	public Room(String name) { 
		name = room.toString();
		this.exams = new HashSet<>();
	}
	
	public Room getRoom() { 
		return this.room;
	}

}

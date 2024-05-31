package rooms_and_exams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Exams_RoomsTest {
	
	@Test
	void test() {
		Exam oop = new Exam();
		assertEquals(Set.of(), oop.getRooms());
		
		Room qdv03_180 = new Room();
		assertEquals(Set.of(), qdv03_180.getExams());
		
		oop.addRoom(qdv03_180);
		assertEquals(Set.of(qdv03_180), oop.getRooms());
		assertEquals(Set.of(oop), qdv03_180.getExams());
		
		oop.removeRoom(qdv03_180);
		assertEquals(Set.of(), oop.getRooms());
		assertEquals(Set.of(), qdv03_180.getExams());
	}
	

}

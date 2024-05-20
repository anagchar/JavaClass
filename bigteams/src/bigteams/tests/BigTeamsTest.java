package bigteams.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import bigteams.Student;
import bigteams.Team;

class BigTeamsTest {

	@Test
	void test() {
		Student alice = new Student();
		assertNull(alice.getTeam());
		
		Student bob = new Student();
		Team team1 = new Team();
		assertEquals(Set.of(), team1.getMembers());
		
		alice.joinTeam(team1);
		assertSame(team1, alice.getTeam());
		assertEquals(Set.of(alice), team1.getMembers());
		
		bob.joinTeam(team1);
		assertEquals(Set.of(alice, bob), team1.getMembers());
		
		alice.leaveTeam();
		assertNull(alice.getTeam());
		assertEquals(Set.of(bob), team1.getMembers());
	}

}

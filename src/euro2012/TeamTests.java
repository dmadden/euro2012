package euro2012;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamTests {
	
	/*
	 * compareTo() returns 1 if the team which is the parameter of compareTo() is "lower in the table"
	 * and it returns -1 if the team which is the parameter of compareTo() is "higher in the table"
	 */
	
	// Liverpool have a greater points score
	@Test
	public void compareToTestOnPoints() {
		Team liverpool = new Team("Liverpool", 5, 4, 1, 12, 8, 4);
		Team wigan = new Team("Wigan", 5, 2, 3, 6, 7, 11);
		assertEquals(1,liverpool.compareTo(wigan));
	}
	
	// Equals points, but Liverpool have a better goal difference
	@Test
	public void compareToTestOnGoalDifference() {
		Team liverpool = new Team("Liverpool", 5, 5, 0, 15, 8, 4);
		Team wigan = new Team("Wigan", 5, 5, 0, 15, 7, 11);
		assertEquals(1,liverpool.compareTo(wigan));
	}
	
	// Equals points, same goal difference but Liverpool have scored more goals
	@Test
	public void compareToTestOnGoalsFor() {
		Team liverpool = new Team("Liverpool", 5, 5, 0, 15, 8, 4);
		Team wigan = new Team("Wigan", 5, 5, 0, 15, 6, 2);
		assertEquals(1,liverpool.compareTo(wigan));
	}
	
	// Equal everything else, comparing on Team.name
	@Test
	public void compareToTestOnAlphabeticalOrder() {
		Team a = new Team("a", 5, 5, 0, 15, 8, 4);
		Team b = new Team("b", 5, 5, 0, 15, 8, 4);
		Team c = new Team("c", 5, 5, 0, 15, 8, 4);
		assertEquals(1,a.compareTo(b));
		assertEquals(1,b.compareTo(c));
		assertEquals(-1,c.compareTo(b));
		assertEquals(-1,b.compareTo(a));
	}
	
	@Test
	public void updateStatsTest() {
		
		Team liverpool = new Team("Liverpool");
		Team wigan = new Team("Wigan");
		Team city = new Team("Manchester City");
		Team celtic = new Team("Celtic");
		
		Match match1 = new Match(liverpool, wigan);
		match1.setHomeScore(3);
		match1.setAwayScore(0);
		liverpool.addMatchToList(match1);
		
		assertEquals(1, liverpool.getFixtures().size());
		assertEquals(3, liverpool.getGoalsFor());
		
		Match match2 = new Match(liverpool, city);
		match2.setHomeScore(4);
		match2.setAwayScore(3);
		liverpool.addMatchToList(match2);
		
		assertEquals(2, liverpool.getFixtures().size());
		assertEquals(7, liverpool.getGoalsFor());
		assertEquals(3, liverpool.getGoalsAgainst());
		assertEquals(4, liverpool.getGoalDifference());
		
		Match match3 = new Match(celtic, liverpool);
		match3.setHomeScore(2);
		match3.setAwayScore(1);
		liverpool.addMatchToList(match3);
		
		assertEquals(8, liverpool.getGoalsFor());
		assertEquals(3, liverpool.getGoalDifference());
		
	}
	
	
}
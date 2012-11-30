package euro2012;

import java.util.ArrayList;

public class Team implements Comparable<Team> {
	
	// constants used in compareTo()
	public static final int HIGHER = 1;
	public static final int LOWER = -1;
	
	private String name;
	private ArrayList<Match> fixtures = new ArrayList<Match>();
	//private Table table;
	private int played;
	private int won;
	private int lost;
	private int points;
	private int goalsFor;
	private int goalsAgainst;
	private int goalDifference;
	
	public Team(String name) {
		this.name = name;
	}
	
	// Constructor just used for testing.
	public Team(String name, int played, int won, int lost, int points,
			int goalsFor, int goalsAgainst) {
		this.name = name;
		this.played = played;
		this.won = won;
		this.lost = lost;
		this.points = points;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
	}



	@Override
	public int compareTo(Team t) {
		
		if(this.points > t.points) {
			return HIGHER;
		}
		if(this.points == t.points) {
			if(this.goalDifference > t.goalDifference) {
				return HIGHER;
			}
			if(this.goalDifference == t.goalDifference) {
				if(this.goalsFor > t.goalsFor) {
					return HIGHER;
				}
				if(this.goalsFor == t.goalsFor) {
					if(this.name.compareTo(t.name) < 0) {
						return HIGHER;
					}
				}
			}
		}
		
		return LOWER;
	}
	
	public void addMatchToList(Match match) {
		fixtures.add(match);
		
		if(fixtures.get(fixtures.size()-1).getHomeTeam().getName()==name){
			goalsFor += fixtures.get(fixtures.size()-1).getHomeScore();
			goalsAgainst += fixtures.get(fixtures.size()-1).getAwayScore();
		}else{
			goalsFor += fixtures.get(fixtures.size()-1).getAwayScore();
			goalsAgainst += fixtures.get(fixtures.size()-1).getHomeScore();
		}
		goalDifference = goalsFor - goalsAgainst;
	}
	

	public String getName() {
		return name;
	}

	public ArrayList<Match> getFixtures() {
		return fixtures;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalDifference() {
		return goalDifference;
	}

	public void setGoalDifference() {
		this.goalDifference = goalsFor - goalsAgainst;
	}	
}
package euro2012;

public class Match {

	private Team homeTeam;
	private Team awayTeam;
	private int homeScore;
	private int awayScore;
	private boolean matchPlayed;
	private int round;
	
	public Match(Team home, Team away){
		this.homeTeam = home;
		this.awayTeam = away;
		this.matchPlayed = false;
		//this.round = round;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public boolean isMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(boolean matchPlayed) {
		this.matchPlayed = matchPlayed;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
}
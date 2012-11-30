package euro2012;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private List<Team> listOfTeams = new ArrayList<Team>();
	
	public Table(ArrayList<Team> teamList){
		this.listOfTeams = listOfTeams;
	}
	
	// Implement the round robin scheduling algorithm
	public void generateFixtures(){
		
	}
	
	// heapsort? quicksort? use compareTo() in team class
	public void sortTeamsBasedOnPosition(){
		
	}

	public List<Team> getListOfTeams() {
		return listOfTeams;
	}
	
}

package euro2012;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LeagueTableModel extends AbstractTableModel {
	
	private List<Team> teams = new ArrayList<Team>();

	private final int NUMBER_COLUMNS = 9;
	private final String COLUMN1 = "Name";
	private final String COLUMN2 = "Played";
	private final String COLUMN3 = "Won";
	private final String COLUMN4 = "Draw";
	private final String COLUMN5 = "Lost";
	private final String COLUMN6 = "Goals For";
	private final String COLUMN7 = "Goals Against";
	private final String COLUMN8 = "Goal Difference";
	private final String COLUMN9 = "Points";

	public LeagueTableModel(List<Team> teams){
		this.teams = teams;
	}
	
	@Override
	public int getColumnCount() {		
		return NUMBER_COLUMNS;
	}

	@Override
	public int getRowCount() {		
		return teams.size();
	}
	
	@Override
	public String getColumnName(int column){
		switch (column){
		case 0:
			return COLUMN1;
		case 1:
			return COLUMN2;
		case 2:
			return COLUMN3;
		case 3:
			return COLUMN4;
		case 4:
			return COLUMN5;
		case 5:
			return COLUMN6;
		case 6:
			return COLUMN7;
		case 7:
			return COLUMN8;
		case 8:
			return COLUMN9;
		default:
				throw new IndexOutOfBoundsException("Column does not exist");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		if(rowIndex>teams.size())
			throw new IndexOutOfBoundsException("Row does not exist");
		
		Team team = teams.get(rowIndex);
		switch (colIndex){
		case 0:
			return team.getName();
		case 1:
			return team.getPlayed();
		case 2:
			return team.getWon();
//		case 3:
//			return team.getDraw();
		case 4:
			return team.getLost();
		case 5:
			return team.getGoalsFor();
		case 6:
			return team.getGoalsAgainst();
		case 7:
			return team.getGoalDifference();
		case 8:
			return team.getPoints();
		default:
			throw new IndexOutOfBoundsException("Column does not exist");
		}
		
	}

}
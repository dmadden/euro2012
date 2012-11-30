package euro2012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {
	
	
	private final int NUMBER_OF_TEAMS = 16;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu helpMenu = new JMenu("Help");
	private JMenuItem newMenuItem = new JMenuItem("New");
	private JMenuItem openMenuItem = new JMenuItem("Open...");
	private JMenuItem saveMenuItem = new JMenuItem("Save");
	private JLabel[] fixtureTeamsLeft = new JLabel[NUMBER_OF_TEAMS];
	private JLabel[] fixtureTeamsRight = new JLabel[NUMBER_OF_TEAMS];
	private JTextField[] scores = new JTextField[NUMBER_OF_TEAMS*2];
	private ImageIcon[] flags = new ImageIcon[NUMBER_OF_TEAMS];
	private JButton addScoresButton = new JButton("Add Scores");
	private List<Team> teams = new ArrayList<Team>();
	private LeagueTableModel leagueTableModel = new LeagueTableModel(teams);
	private JTable leagueTable = new JTable(leagueTableModel);
	private JScrollPane scrollPane = new JScrollPane(leagueTable);
	
	public MainWindow() {
		for(int i = 0;i<NUMBER_OF_TEAMS;i++){
			scores[i] = new JTextField("", 2);
			scores[i+NUMBER_OF_TEAMS] = new JTextField("", 2);
		}
		
		
		this.setLayout(new MigLayout());
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		
		loadTeams(); //loads team names to fixture labels		
		
		
		//Test fixture
		for(int i=0; i<NUMBER_OF_TEAMS/2; i++){
			//for testing purposes, fixtureTeamsRight[] is a reverse of the fixtureTeamsLeft[] array
			fixtureTeamsRight[i] = new JLabel(fixtureTeamsLeft[NUMBER_OF_TEAMS-(1+i)].getText(),flags[NUMBER_OF_TEAMS-(1+i)], JLabel.LEFT);
			
			this.add(fixtureTeamsLeft[i],"right");
			this.add(scores[i]);
			this.add(new JLabel("-"));			
			this.add(scores[i+NUMBER_OF_TEAMS]);
			if(i==0){
				this.add(fixtureTeamsRight[i], "wrap");
				this.add(scrollPane, "pos 350 0, wrap");
			}else
				this.add(fixtureTeamsRight[i],"wrap");
		}
		
		
		this.add(addScoresButton, "span 6, right");
		
		
	}	


	public static void main(String[] args) {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		MainWindow mainWindow = new MainWindow();
		mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainWindow.pack();
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);	
	}
	
	
	private void loadTeams() {		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream("res/teams.txt")));
			String team = null;
			int i = 0;
			while((team = in.readLine())!= null) {
				flags[i] = new ImageIcon("res/flags/"+team+".png");
				fixtureTeamsLeft[i] = new JLabel(team, flags[i], JLabel.RIGHT);
				fixtureTeamsLeft[i].setHorizontalTextPosition(SwingConstants.LEFT);
				i++;
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
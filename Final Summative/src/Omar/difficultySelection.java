package Omar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import Georgio.enemies;

public class difficultySelection {
	
	public static String diff_pick = null;
	static String thisLine = null;
	static class_list classList[] = null; 
	static int n = 0;
	
	
	public static void difficulty() 
	{
		//Create the difficulty selection window
	JFrame difficultySelection  = new JFrame("Game");
	difficultySelection.setTitle("Select a difficulty");
	difficultySelection.setSize(630, 630);
	difficultySelection.setLocationRelativeTo(null);
	difficultySelection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	difficultySelection.setVisible(true);

	
	//Header
	JLabel difficulty = new JLabel ("Select a difficulty");
	difficulty.setBounds(200, 25, 210, 75);
	difficulty.setFont(new Font("Forestry",Font.PLAIN,32));
	difficulty.setOpaque(true);
	
	//Initialize Buttons
	JButton easy = new JButton("Easy");
	easy.setLayout(new BorderLayout());
	easy.setBounds(205, 125, 200, 75);
	easy.setFont(new Font("Forestry",Font.PLAIN,32));
	
	JButton normal = new JButton("Normal");
	normal.setLayout(new BorderLayout());
	normal.setBounds(205, 275, 200, 75);
	normal.setFont(new Font("Forestry",Font.PLAIN,32));
	
	JButton hard = new JButton("Hard");
	hard.setLayout(new BorderLayout());
	hard.setBounds(205, 420, 200, 75);
	hard.setFont(new Font("Forestry",Font.PLAIN,32));
	
	
	difficultySelection.setLayout(new BorderLayout());
	//Add the background image
	JLabel background=new JLabel(
			new ImageIcon("diff_background.png"));
	//add buttons and background to window 
	background.add(easy);
	background.add(normal);
	background.add(hard);
	background.add(difficulty);
	difficultySelection.add(background);
	difficultySelection.setResizable(false);
		
	
	
	
	//Button clicked
	easy.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			diff_pick = "easy"; //select difficulty
			enemies.difficulty("easy"); //select difficulty
			classSelection.read(thisLine, classList, n); //Continue to class selection
			difficultySelection.dispose();
		}
	}
	);
	
	//Check button click
	normal.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			diff_pick = "normal"; //select difficulty
			enemies.difficulty("normal"); //select difficulty
			classSelection.read(thisLine, classList, n); //Continue to class selection
			difficultySelection.dispose();
		}
	}
	);
	
	//check button click
	hard.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			diff_pick = "hard"; //select difficulty
			enemies.difficulty("hard"); //select difficulty
			classSelection.read(thisLine, classList, n); //Continue to class selection
			difficultySelection.dispose();
		}
	}
	);
	}
}
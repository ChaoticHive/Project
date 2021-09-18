package Omar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {

	public static void main(String[] args) 
	{	
		//game
		//Create the graphics window
		JButton newGame;
		JButton resume;
		JFrame game = new JFrame("Game");
		game.setTitle("Welcome");
		game.setSize(626,626);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		game.setResizable(false);
	
		//Background Setup
		game.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("b1.png"));
		background.setLayout(new FlowLayout());
		
		//Button Options Setup
		newGame= new JButton("New Game");
		newGame.setBounds(133, 110, 300, 55);
		newGame.setOpaque(false);
		newGame.setContentAreaFilled(false);
		newGame.setBorderPainted(false);
		newGame.setFont(new Font("Minion Pro Cond",Font.PLAIN,50));
		newGame.setFocusPainted(false);
		newGame.setForeground(Color.getHSBColor(225, 0, 0));
		
		resume= new JButton("Resume Game");
		resume.setBounds(108, 370, 350, 75);
		resume.setOpaque(false);
		resume.setContentAreaFilled(false);
		resume.setBorderPainted(false);
		resume.setFont(new Font("Minion Pro Cond",Font.PLAIN,50));
		resume.setFocusPainted(false);
		resume.setForeground(Color.getHSBColor(255, 0, 0));
		
		//Make the background visible
		background.setVisible(true);
		
		//Add the buttons and background to the window
		game.add(newGame);
		game.add(resume);
		game.add(background);
		
		//Refresh the window -- NEEDED
		game.setSize(399,399);
		game.setSize(626,626);
		
		//Create a listener to check if the new game button is clicked
		newGame.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	newGame.setVisible(false);   // Hide this button
		    	difficultySelection.difficulty();  // Go to the difficulty selection window
		    	//classSelection.read(thisLine, classList, n);
		       game.dispose(); //Close this window
		    }
		});

		//Create a listener to check if the resume game button is clicked
		resume.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	resume.setVisible(false); //Hide the button
		    	//Insert reader for previous save
		    	game.dispose(); //Close this window
		    	resumeGame.resume(); //Run the resume game method
		    	MainMenu.mainMenu(); // Go to the main manu
		    }
		});

	}
}

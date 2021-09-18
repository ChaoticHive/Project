package Omar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Georgio.bossFight;
import Georgio.fight;

public class MainMenu {
	
	
	public static void mainMenu()
	{
	JButton Fight = new JButton("Fight");
	Fight.setLayout(new BorderLayout());
	Fight.setBounds(100, 175, 100, 75);
	Fight.setFont(new Font("Jokerman",Font.PLAIN,24));
	
	JButton inventory = new JButton("Inventory");
	inventory.setLayout(new BorderLayout());
	inventory.setBounds(390, 175, 100, 75);
	inventory.setFont(new Font("Jokerman",Font.PLAIN,13));

	JButton shop = new JButton("Shop");
	shop.setLayout(new BorderLayout());
	shop.setBounds(100, 275, 100, 75);
	shop.setFont(new Font("Jokerman",Font.PLAIN,24));
	
	//ONLY SHOW IF PLAYER REACHES A CERTAIN LEVEL!!!!!!!
	JButton boss = new JButton("Boss");
	boss.setBounds(390, 275, 100, 75);
	boss.setFont(new Font("Jokerman",Font.PLAIN,24));
	
	JButton exit = new JButton("Exit");
	exit.setLayout(new BorderLayout());
	exit.setBounds(50, 500, 500, 75);
	
	JButton save = new JButton("Save");
	save.setLayout(new BorderLayout());
	save.setBounds(50, 400, 500, 75);
	
	JFrame menu = new JFrame("Main Menu");
	menu.setTitle("Main Menu");
	menu.setSize(650,650);
	menu.setLocationRelativeTo(null);
	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	menu.setVisible(true);
	menu.setResizable(true);

	
	menu.setLayout(new BorderLayout());
	JLabel background = new JLabel(
			new ImageIcon("menubackground.png"));
	background.add(Fight);
	background.add(inventory);
	background.add(shop);
	background.add(boss);
	background.add(exit);
	background.add(save);
	menu.add(background);
	menu.setResizable(false);
	// Just for refresh :) Not optional!
	menu.setSize(399,399);
	menu.setSize(626,626);
	
	
	
	//Button Functions
	Fight.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	menu.dispose();
	    	fight.fightMenu();
	    	//Insert code for boss fight
	    }
	}
	);
	
	inventory.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	menu.dispose();
	    	Inventory.inventory();
	    	//playerInventory.invArmor();
	    	//Insert code for boss fight
	    }
	}
	);
	
	shop.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	menu.dispose();
	    	shopBuy.buy();
	    	//Insert code for boss fight
	    }
	}
	);
	
	boss.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	if (playerData.playerlvl >= 5)
	    	{
	    		bossFight.boss();
	    		menu.dispose();
	    	}
	    	else
	    	{
	    		JFrame bossError = new JFrame("Uh Oh");
	    		bossError.setSize(200,75);
	    		bossError.setLocationRelativeTo(null);
	    		bossError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		bossError.setVisible(true);
	    		bossError.setResizable(false);
		    	
		    	JButton b7 = new JButton();
		    	b7.setLayout(new BorderLayout());
		    	JLabel l1 = new JLabel("You must be at least level");
				JLabel l2 = new JLabel("5 before you can do this!");
		    	//b7.setBounds(125, 50, 75, 25);
				b7.add(BorderLayout.CENTER, l1);
				b7.add(BorderLayout.SOUTH, l2);
				bossError.add(b7);
		    	
		    	b7.addActionListener(new ActionListener() {
		    	    public void actionPerformed(ActionEvent e)
		    	    {
		    	    	b7.setVisible(false);
		    	    	bossError.dispose();
		    	    }
		    	}
		    	);
	    	}
	    	
	    	//Insert code for boss fight
	    }
	}
	);
	exit.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	menu.dispose();
	    }
	}
	);
	
	save.addActionListener(new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	//SaveGame.SaveGame(stuff);
	    	JFrame save = new JFrame("Saved");
	    	save.setSize(200,75);
	    	save.setLocationRelativeTo(null);
	    	save.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	save.setVisible(true);
	    	save.setResizable(false);
	    	classSelection.playerSave();
	    	
	    	JButton b7 = new JButton("Progress Saved");
	    	b7.setLayout(new BorderLayout());
	    	//b7.setBounds(125, 50, 75, 25);
	    	save.add(b7);
	    	
	    	b7.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e)
	    	    {
	    	    	b7.setVisible(false);
	    	    	save.dispose();
	    	    }
	    	}
	    	);
	    }
	}
	);
	}
}

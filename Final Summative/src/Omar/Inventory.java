package Omar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Georgio.items;

public class Inventory {

	public static items[] playerInvWeapons = new items[100];
	public static items[] playerInvArmor = new items[100];
	public static int n = 0;
	
	public static void inventory() {
		//Creation of inventory Menu
		JFrame inventory = new JFrame("Game");
		inventory.setTitle("Inventory");
		inventory.setSize(626, 626);
		inventory.setLocationRelativeTo(null);
		inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventory.setVisible(true);
		inventory.setResizable(false);

		// Button Setup
		JButton back = new JButton("Back");
		back.setLayout(new BorderLayout());
		back.setBounds(50, 500, 500, 75);

		JButton weapons = new JButton("Weapons");
		weapons.setLayout(new BorderLayout());
		weapons.setBounds(50, 125, 500, 75);

		JButton armor = new JButton("Armor");
		armor.setLayout(new BorderLayout());
		armor.setBounds(50, 275, 500, 75);

		inventory.setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("menubackground.png"));

		background.add(back);
		background.add(weapons);
		background.add(armor);
		inventory.add(background);

		// Just for refresh :) Not optional!
		inventory.setSize(399, 399);
		inventory.setSize(626, 626);

		back.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				inventory.dispose();
				MainMenu.mainMenu();
			}
		});

		weapons.addActionListener(new ActionListener() 
		{
			//If the weapons inventory is selected get the player inventory data for weapons
			public void actionPerformed(ActionEvent e) 
			{
				playerInventory.invWeapons(playerInvWeapons);
				JTextArea textArea = new JTextArea("", 40, 50);
				textArea.setFont(new Font("BadaBoom BB", Font.PLAIN, 28));
				for  (int x = 0; x < playerInvWeapons.length; x++) 
				{
					if (playerInvWeapons[n] != null)
					{
						textArea.append(playerInvWeapons[n].itemName + "\r\n");
					}
					
					n++;
				}
				n = 0;

				//Create a scrollable text window to allow user to see the entire inventory
				JScrollPane invMenu = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				//Create a text field for user to enter their selection into
				JTextField answer = new JTextField("Selection");
				JButton confirm = new JButton("Confirm");
				confirm.setVisible(true);
				confirm.setBounds(475, 450, 85, 50);
				answer.setBounds(275, 450, 275, 50);
				invMenu.setBounds(200, 15, 390, 420);
				armor.setVisible(false);
				weapons.setVisible(false);
				invMenu.setVisible(true);
				background.add(invMenu);
				background.add(confirm);
				background.add(answer);
				confirm.addActionListener(new ActionListener()
				{
					//If the confirm button is pressed, take the user input and check the entire player weapons array
					public void actionPerformed(ActionEvent e) 
					{
						String finalAnswer = answer.getText();
						for (int x = 0; x < playerInvWeapons.length; x++)
						{
							if (playerInvWeapons[n] != null)
							{
							if (finalAnswer.equalsIgnoreCase(playerInvWeapons[n].itemName)) 
							{
								//If the weapon is found it will be swapped with the one that is currently equipped
								//Nothing happens if it does not find the weapon
								items swap = new items (playerInvWeapons[n].itemName, playerInvWeapons[n].itemDmg,
										playerInvWeapons[n].itemHlth, playerInvWeapons[n].itemGold);
								playerInvWeapons[n].itemName = playerData.weapon.itemName;
								playerInvWeapons[n].itemDmg = playerData.weapon.itemDmg;
								playerInvWeapons[n].itemHlth = playerData.weapon.itemHlth;
								playerInvWeapons[n].itemGold = playerData.weapon.itemGold;
								
								textArea.setText( textArea.getText().replaceAll( finalAnswer, playerData.weapon.itemName));
								playerData.weapon = swap;
								playerData.playerdmg = 10 + playerData.weapon.itemDmg;
								
								
								//Equipped Window
								JFrame eqiupped = new JFrame("Game");
								eqiupped.setTitle("fight");
								eqiupped.setSize(175, 125);
								eqiupped.setLocationRelativeTo(null);
								eqiupped.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								eqiupped.setVisible(true);
								eqiupped.setResizable(false);
								JLabel equippedWindow1 = new JLabel("Weapon");
								equippedWindow1.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
								JLabel equippedWindow2 = new JLabel("Equipped");
								equippedWindow2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
								JButton b7 = new JButton("");
								b7.setLayout(new BorderLayout());
								b7.add(BorderLayout.NORTH, equippedWindow1);
								b7.add(BorderLayout.SOUTH, equippedWindow2);
								eqiupped.add(b7);

								// This checks to see if the button was clicked
								b7.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										b7.setVisible(false);
										eqiupped.dispose();
										inventory.dispose();
										MainMenu.mainMenu();		
										classSelection.playerSave();
										playerInventory.saveInvWeapons(playerInvWeapons);
										
									}
								});
							}
						}
							n++;
						}
						n = 0;
					}
				});
			}
		});

		//If the armor button use same code for weapon but swap weapon for armor instead
		armor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				playerInventory.invArmor(playerInvArmor);
				JTextArea textArea = new JTextArea("", 40, 50);
				textArea.setFont(new Font("BadaBoom BB", Font.PLAIN, 28));
				for  (int x = 0; x < playerInvArmor.length; x++) 
				{
					if (playerInvWeapons[n] != null)
					{
						textArea.append(playerInvArmor[n].itemName + "\r\n");
					}
					
					n++;
				}
				n = 0;

				
				JScrollPane invMenu = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				JTextField answer = new JTextField("Selection");
				JButton confirm = new JButton("Confirm");
				confirm.setVisible(true);
				confirm.setBounds(475, 450, 85, 50);
				answer.setBounds(275, 450, 275, 50);
				invMenu.setBounds(200, 15, 390, 420);
				armor.setVisible(false);
				weapons.setVisible(false);
				invMenu.setVisible(true);
				background.add(invMenu);
				background.add(confirm);
				background.add(answer);
				confirm.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						
						String finalAnswer = answer.getText();
						for (int x = 0; x < playerInvArmor.length; x++)
						{
							if (playerInvArmor[n] == null)
							{
								
							}
							else if (finalAnswer.equalsIgnoreCase(playerInvArmor[n].itemName)) 
							{
								items swap = new items (playerInvArmor[n].itemName, playerInvArmor[n].itemDmg,
										playerInvArmor[n].itemHlth, playerInvArmor[n].itemGold);
								playerInvArmor[n].itemName = playerData.armor.itemName;
								playerInvArmor[n].itemDmg = playerData.armor.itemDmg;
								playerInvArmor[n].itemHlth = playerData.armor.itemHlth;
								playerInvArmor[n].itemGold = playerData.armor.itemGold;
								
								textArea.setText( textArea.getText().replaceAll( finalAnswer, playerData.armor.itemName));
								playerData.armor = swap;
								playerData.playerHlth = 75 + playerData.armor.itemHlth;
								
								
								//Equipped Window
								JFrame eqiupped = new JFrame("Game");
								eqiupped.setTitle("fight");
								eqiupped.setSize(175, 125);
								eqiupped.setLocationRelativeTo(null);
								eqiupped.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								eqiupped.setVisible(true);
								eqiupped.setResizable(false);
								JLabel equippedWindow1 = new JLabel("Armor");
								equippedWindow1.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
								JLabel equippedWindow2 = new JLabel("Equipped");
								equippedWindow2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
								JButton b7 = new JButton("");
								b7.setLayout(new BorderLayout());
								b7.add(BorderLayout.NORTH, equippedWindow1);
								b7.add(BorderLayout.SOUTH, equippedWindow2);
								eqiupped.add(b7);

								// This checks to see if the button was clicked
								b7.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										b7.setVisible(false);
										eqiupped.dispose();
										inventory.dispose();
										classSelection.playerSave();
										MainMenu.mainMenu();
										playerInventory.saveInvArmor(playerInvArmor);
									}
								});
							}
							n++;
						}
						n = 0;
						// USE SAME CODE FOR ARMOR AFTER THIS IS COMPLETE
					}
				});
			}
		});
	}
}

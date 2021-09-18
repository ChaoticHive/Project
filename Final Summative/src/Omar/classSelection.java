package Omar;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import Georgio.items;
import Georgio.playerClass;

public class classSelection {
	
	static String thisLine;
	static class_list classOptions[] = new class_list[3];
	static int counter;
	static playerData[] OldPlayerData;
	public static playerData stuff;
	static String h = difficultySelection.diff_pick;
	public static int i = 3;

	public static void read(String x, class_list[] y, int z) {
		thisLine = x;
		counter = z;
		
		// Setup Array
		{
			try (FileReader f1 = new FileReader("Classes.txt"); BufferedReader inv = new BufferedReader(f1)) 
			{
				while ((thisLine = inv.readLine()) != null) 
				{
					String[] selection = thisLine.split(", ");
					String name = selection[0];
					String weapon = selection[1];
					String armor = selection[2];
					
					class_list c1 = new class_list(name, weapon, armor);
					classOptions[z] = new class_list("", "", "");
					classOptions[z] = c1;
					z++;
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		

		//Create buttons
		JButton tank = new JButton();
		tank.setLayout(new BorderLayout());
		JLabel tanklabel1 = new JLabel(classOptions[0].name);
		tanklabel1.setFont(new Font("oldprint", Font.PLAIN, 32));
		JLabel tanklabel2 = new JLabel("Weapon: " + classOptions[0].weapon);
		tanklabel2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 16));
		JLabel tanklabel3 = new JLabel("Armor: " + classOptions[0].armor);
		tanklabel3.setFont(new Font("Minion Pro Cond", Font.PLAIN, 16));
		tank.add(BorderLayout.NORTH, tanklabel1);
		tank.add(BorderLayout.CENTER, tanklabel2);
		tank.add(BorderLayout.SOUTH, tanklabel3);
		tank.setBounds(225, 175, 200, 75);

		JButton balanced = new JButton();
		balanced.setLayout(new BorderLayout());
		JLabel balancedlabel1 = new JLabel(classOptions[1].name);
		balancedlabel1.setFont(new Font("oldprint", Font.PLAIN, 32));
		JLabel balancedlabel2 = new JLabel("Weapon: " + classOptions[1].weapon);
		balancedlabel2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 16));
		JLabel balancedlabel3 = new JLabel("Armor: " + classOptions[1].armor);
		balancedlabel2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 16));
		balanced.add(BorderLayout.NORTH, balancedlabel1);
		balanced.add(BorderLayout.CENTER, balancedlabel2);
		balanced.add(BorderLayout.SOUTH, balancedlabel3);
		balanced.setBounds(225, 275, 200, 75);

		JButton damage = new JButton();
		damage.setLayout(new BorderLayout());
		JLabel damagelabel1 = new JLabel(classOptions[2].name);
		damagelabel1.setFont(new Font("oldprint", Font.PLAIN, 28));
		JLabel damagelabel2 = new JLabel("Weapon: " + classOptions[2].weapon);
		damagelabel2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 16));
		JLabel damagelabel3 = new JLabel("Armor: " + classOptions[2].armor);
		damagelabel2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 16));
		damage.add(BorderLayout.NORTH, damagelabel1);
		damage.add(BorderLayout.CENTER, damagelabel2);
		damage.add(BorderLayout.SOUTH, damagelabel3);
		damage.setBounds(220, 375, 208, 75);

		// Pictures for classes
		JLabel tankPic = new JLabel(new ImageIcon("tank.png"));
		tankPic.setBounds(65, 175, 200, 75);
		JLabel balancedPic = new JLabel(new ImageIcon("balanced.png"));
		balancedPic.setBounds(65, 275, 200, 75);
		JLabel damagePic = new JLabel(new ImageIcon("high damage.png"));
		damagePic.setBounds(65, 375, 200, 75);

		JFrame pickClass = new JFrame("pickClass");
		pickClass.setTitle("Select a class");
		pickClass.setSize(626, 626);
		pickClass.setLocationRelativeTo(null);
		pickClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pickClass.setVisible(true);
		pickClass.add(tankPic);
		pickClass.add(balancedPic);
		pickClass.add(damagePic);
		pickClass.setResizable(false);

		pickClass.setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("background.png"));
		
		background.add(tank);
		background.add(balanced);
		background.add(damage);

		background.setVisible(true);
		pickClass.add(background);

		//Button Listener
		tank.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				//Select Tank Class
				int weaponHlth = 0;
				int weaponGold = 15;
				int weaponDmg = 10;
				playerClass.pClass("tank");
				String a = classOptions[0].weapon;
				items weapon = new items(a,weaponDmg, weaponHlth, weaponGold);
				String b = classOptions[0].armor;
				int armorHlth = 125;
				int armorGold = 15;
				int armorDmg = 0;
				items armor = new items(b,armorDmg, armorHlth, armorGold);
				int c = playerClass.playerHlth;
				int d = playerClass.playerLvl;
				int f = playerClass.playerDmg;
				int g = playerClass.playerGld;
				stuff = new playerData(h, weapon, armor, c, d, f, g, i);

				//Select Data
				playerData.difficulty = h;
				playerData.weapon = weapon;
				playerData.armor = armor;
				playerData.playerHlth = 75 + armor.itemHlth;
				playerData.playerlvl = d;
				playerData.playerdmg = 10 + weapon.itemDmg;
				playerData.playergld = g;
				playerData.playerlives = i;

				//Reset Inventory
				items[] startingInv = new items[1];
				items[] weaponsShop = new items[100];
				playerInventory.shopWeapons(weaponsShop);
				playerInventory.saveShopWeapons(weaponsShop);
				playerInventory.saveInvWeapons(startingInv);
				playerInventory.saveInvArmor(startingInv);
				
				MainMenu.mainMenu(); //Continue to Main Menu
				pickClass.dispose();
			}
		});

		//Button Listener
		balanced.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int weaponHlth = 0;
				int weaponGold = 15;
				int weaponDmg = 20;

				//Select Balance Class
				playerClass.pClass("balance");
				String a = classOptions[1].weapon;
				items weapon = new items(a,weaponDmg, weaponHlth, weaponGold);
				String b = classOptions[1].armor;
				int armorHlth = 50;
				int armorGold = 15;
				int armorDmg = 0;
				items armor = new items(b,armorDmg, armorHlth, armorGold);
				int d = playerClass.playerLvl;
				int g = playerClass.playerGld;
				
				//Select Data
				playerData.difficulty = h;
				playerData.weapon = weapon;
				playerData.armor = armor;
				playerData.playerHlth = 75 + armor.itemHlth;
				playerData.playerlvl = d;
				playerData.playerdmg = 10 + weapon.itemDmg;
				playerData.playergld = g;
				playerData.playerlives = i;

				//Reset Inventory
				items[] startingInv = new items[1];
				items[] weaponsShop = new items[100];
				playerInventory.shopWeapons(weaponsShop);
				playerInventory.saveShopWeapons(weaponsShop);
				playerInventory.saveInvWeapons(startingInv);
				playerInventory.saveInvArmor(startingInv);
				
				MainMenu.mainMenu();//Continue to Main Menu
				pickClass.dispose();
			}
		});

		//Button Listener
		damage.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Select Damage Class
				playerClass.pClass("damage");
				int weaponHlth = 0;
				int weaponGold = 15;
				int weaponDmg = 40;
				String a = classOptions[2].weapon;
				items weapon = new items(a,weaponDmg, weaponHlth, weaponGold);
				String b = classOptions[2].armor;
				int armorHlth = 25;
				int armorGold = 15;
				int armorDmg = 0;
				items armor = new items(b,armorDmg, armorHlth, armorGold);
				int d = playerClass.playerLvl;
				int g = playerClass.playerGld;
				int i = playerClass.playerlives;

				//Select Data
				playerData.difficulty = h;
				playerData.weapon = weapon;
				playerData.armor = armor;
				playerData.playerHlth = 75 + armor.itemHlth;
				playerData.playerlvl = d;
				playerData.playerdmg = 10 + weapon.itemDmg;
				playerData.playergld = g;
				playerData.playerlives = i;

				
				//Reset Inventory
				items[] startingInv = new items[1];
				items[] weaponsShop = new items[100];
				items[] armorShop = new items[100];
				playerInventory.newShopWeapons(weaponsShop);
				playerInventory.newShopArmor(armorShop);
				playerInventory.saveShopWeapons(weaponsShop);
				playerInventory.saveShopArmor(armorShop);
				playerInventory.saveInvWeapons(startingInv);
				playerInventory.saveInvArmor(startingInv);
				
				pickClass.dispose();
				MainMenu.mainMenu(); //Continue to Main Menu
			}
		});
	}

	public static void playerSave() 
	{
		stuff = new playerData(playerData.difficulty, playerData.weapon, playerData.armor, playerData.playerHlth,
				playerData.playerlvl, playerData.playerdmg, playerData.playergld, playerData.playerlives);
		SaveGame.save(stuff);
	}
}
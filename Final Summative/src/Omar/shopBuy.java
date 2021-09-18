package Omar;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Georgio.items;

public class shopBuy {

	public static items[] playerShopWeapons = new items[100];
	public static items[] playerShopArmor = new items[100];
	public static items[] playerInvWeapons = new items[100];
	public static items[] playerInvArmor = new items[100];
	public static int n = 0;
	public static int y = 0;
	public static boolean loop = true;

	public static void buy() {
		JFrame buyWindow = new JFrame("Game");
		buyWindow.setTitle("Shop");
		buyWindow.setSize(626, 626);
		buyWindow.setLocationRelativeTo(null);
		buyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buyWindow.setVisible(true);
		buyWindow.setResizable(false);

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

		buyWindow.setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("menubackground.png"));

		background.add(back);
		background.add(weapons);
		background.add(armor);
		buyWindow.add(background);

		// Just for refresh :) Not optional!
		buyWindow.setSize(399, 399);
		buyWindow.setSize(626, 626);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyWindow.dispose();
				MainMenu.mainMenu();
			}
		});

		weapons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerInventory.invWeapons(playerInvWeapons);
				playerInventory.shopWeapons(playerShopWeapons);
				loop = true;
				JLabel playerGold = new JLabel("<html><pre> Player Gold: " + playerData.playergld + "</pre></html>");
				playerGold.setBounds(0, 20, 150, 40);
				playerGold.setVisible(true);
				playerGold.setOpaque(true);
				playerGold.setFont(new Font("Minion Pro Cond", Font.PLAIN, 12));
				background.add(playerGold);
				JTextArea textArea = new JTextArea("", 40, 50);
				textArea.setFont(new Font("BadaBoom BB", Font.PLAIN, 28));

				for (int x = 0; x < playerShopWeapons.length; x++) {
					if (playerShopWeapons[n] != null) {

						textArea.append(playerShopWeapons[n].itemName + "\r\n");
					}

					n++;
				}
				n = 0;

				JScrollPane invMenu = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				JTextField answer = new JTextField("Selection");
				JButton confirm = new JButton("Confirm");
				confirm.setVisible(true);
				confirm.setBounds(475, 450, 100, 50);
				answer.setBounds(275, 450, 275, 50);
				invMenu.setBounds(200, 15, 390, 420);
				armor.setVisible(false);
				weapons.setVisible(false);
				invMenu.setVisible(true);
				background.add(invMenu);
				background.add(confirm);
				background.add(answer);
				confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String finalAnswer = answer.getText();
						for (int x = 0; x < playerShopWeapons.length; x++) {
							if (playerShopWeapons[n] != null) {
								if (finalAnswer.equalsIgnoreCase(playerShopWeapons[n].itemName)) {
									if (playerData.playergld >= playerShopWeapons[n].itemGold) {
										while (loop == true) {
											if (playerInvWeapons[y] == null) {
												loop = false;
												items bought = new items(playerShopWeapons[n].itemName,
														playerShopWeapons[n].itemDmg, playerShopWeapons[n].itemHlth,
														playerShopWeapons[n].itemGold);
												playerData.playergld = playerData.playergld - bought.itemGold;
												playerInvWeapons[y] = bought;
												textArea.setText(textArea.getText().replaceAll(finalAnswer, " "));
											}
											y++;
										}

										// Purchased Window
										JFrame purchased = new JFrame("Game");
										purchased.setTitle("fight");
										purchased.setSize(175, 125);
										purchased.setLocationRelativeTo(null);
										purchased.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										purchased.setVisible(true);
										purchased.setResizable(false);
										JLabel equippedWindow1 = new JLabel("Weapon");
										equippedWindow1.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
										JLabel equippedWindow2 = new JLabel("Purchased");
										equippedWindow2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
										JButton b7 = new JButton("");
										b7.setLayout(new BorderLayout());
										b7.add(BorderLayout.NORTH, equippedWindow1);
										b7.add(BorderLayout.SOUTH, equippedWindow2);
										purchased.add(b7);

										// This checks to see if the button was
										// clicked
										b7.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												playerShopWeapons[n].itemName = "Sold";
												classSelection.playerSave();
												playerInventory.saveInvWeapons(playerInvWeapons);
												playerInventory.saveShopWeapons(playerShopWeapons);
												b7.setVisible(false);
												purchased.dispose();
												buyWindow.dispose();
												MainMenu.mainMenu();
												n = 0;
												y = 0;
											}
										});
									} else {
										// CODE FOR NOT ENOUGH GOLD
									}
								}
							}

							n++;
						}
						n = 0;
						y = 0;
					}
				});
			}
		});

		armor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerInventory.invArmor(playerInvArmor);
				playerInventory.shopArmor(playerShopArmor);
				loop = true;
				JLabel playerGold = new JLabel("<html><pre> Player Gold: " + playerData.playergld + "</pre></html>");
				playerGold.setBounds(0, 20, 150, 40);
				playerGold.setVisible(true);
				playerGold.setOpaque(true);
				playerGold.setFont(new Font("Minion Pro Cond", Font.PLAIN, 12));
				background.add(playerGold);
				JTextArea textArea = new JTextArea("", 40, 50);
				textArea.setFont(new Font("BadaBoom BB", Font.PLAIN, 28));

				for (int x = 0; x < playerShopArmor.length; x++) {
					if (playerShopWeapons[n] != null) {

						textArea.append(playerShopArmor[n].itemName + "\r\n");
					}

					n++;
				}
				n = 0;

				JScrollPane invMenu = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				JTextField answer = new JTextField("Selection");
				JButton confirm = new JButton("Confirm");
				confirm.setVisible(true);
				confirm.setBounds(475, 450, 100, 50);
				answer.setBounds(275, 450, 275, 50);
				invMenu.setBounds(200, 15, 390, 420);
				armor.setVisible(false);
				weapons.setVisible(false);
				invMenu.setVisible(true);
				background.add(invMenu);
				background.add(confirm);
				background.add(answer);
				confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String finalAnswer = answer.getText();
						for (int x = 0; x < playerShopArmor.length; x++) {
							if (playerShopArmor[n] != null) {
								if (finalAnswer.equalsIgnoreCase(playerShopArmor[n].itemName)) {
									if (playerData.playergld >= playerShopArmor[n].itemGold) {
										while (loop == true) {
											if (playerInvWeapons[y] == null) {
												loop = false;
												items bought = new items(playerShopArmor[n].itemName,
														playerShopArmor[n].itemDmg, playerShopArmor[n].itemHlth,
														playerShopArmor[n].itemGold);
												playerData.playergld = playerData.playergld - bought.itemGold;
												playerInvWeapons[y] = bought;
												textArea.setText(textArea.getText().replaceAll(finalAnswer, " "));
											}
											y++;
										}

										// Purchased Window
										JFrame purchased = new JFrame("Game");
										purchased.setTitle("fight");
										purchased.setSize(175, 125);
										purchased.setLocationRelativeTo(null);
										purchased.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										purchased.setVisible(true);
										purchased.setResizable(false);
										JLabel equippedWindow1 = new JLabel("Weapon");
										equippedWindow1.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
										JLabel equippedWindow2 = new JLabel("Purchased");
										equippedWindow2.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
										JButton b7 = new JButton("");
										b7.setLayout(new BorderLayout());
										b7.add(BorderLayout.NORTH, equippedWindow1);
										b7.add(BorderLayout.SOUTH, equippedWindow2);
										purchased.add(b7);

										// This checks to see if the button was
										// clicked
										b7.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												playerShopArmor[n].itemName = "Sold";
												classSelection.playerSave();
												playerInventory.saveInvArmor(playerInvArmor);
												playerInventory.saveShopArmor(playerShopArmor);
												b7.setVisible(false);
												purchased.dispose();
												buyWindow.dispose();
												MainMenu.mainMenu();
												n = 0;
												y = 0;
											}
										});
									} else {
										// CODE FOR NOT ENOUGH GOLD
									}
								}
							}

							n++;
						}
						n = 0;
						y = 0;
					}
				});
			}
		});
	}
}

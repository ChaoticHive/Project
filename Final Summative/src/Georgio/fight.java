package Georgio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Omar.MainMenu;
import Omar.classSelection;
import Omar.playerData;

import java.util.*;

public class fight {

	public static int n = 0;
	public static int kills = 0;
	public static int deaths = 0;
	public static int enemyHp = enemies.enemyHealth();
	public static int damg = playerData.playerdmg;
	public static int playerHp = playerData.playerHlth;
	public static int enemyDmg = enemies.enemyDamage();
	public static int plyrLvl = playerData.playerlvl;
	public static int xpGain = 0;
	public static int totalxp = 0;
	public static boolean enemyHeal = false;

	public static void fightMenu() {

		//Create Fight Window
		playerHp = playerData.playerHlth;
		enemyHp = enemies.enemyHealth();

		JFrame fight = new JFrame("Game");
		fight.setTitle("fight");
		fight.setSize(630, 630);
		fight.setLocationRelativeTo(null);
		fight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fight.setVisible(true);
		fight.setResizable(false);

		// Initialize Buttons
		JButton run = new JButton("Run");
		run.setLayout(new BorderLayout());
		run.setBounds(0, 495, 630, 110);
		run.setFont(new Font("Forestry", Font.PLAIN, 92));

		JButton attack = new JButton("Attack");
		attack.setLayout(new BorderLayout());
		attack.setBounds(0, 375, 315, 120);
		attack.setFont(new Font("Forestry", Font.PLAIN, 72));

		JButton heal = new JButton("Heal");
		heal.setLayout(new BorderLayout());
		heal.setBounds(315, 375, 315, 120);
		heal.setFont(new Font("Forestry", Font.PLAIN, 72));

		JButton notifConfirm = new JButton("OK");
		notifConfirm.setLayout(new BorderLayout());
		notifConfirm.setBounds(380, 505, 220, 75);
		notifConfirm.setVisible(false);

		// Player Health and Enemy Health
		JLabel playerHealth = new JLabel(
				"<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth + "</pre></html>");
		playerHealth.setBounds(10, 20, 95, 50);
		playerHealth.setVisible(true);
		playerHealth.setOpaque(true);
		playerHealth.setFont(new Font("Minion Pro Cond", Font.PLAIN, 12));

		JLabel enemyHealth = new JLabel(
				"<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth() + "</pre></html>");
		enemyHealth.setBounds(430, 20, 95, 50);
		enemyHealth.setVisible(true);
		enemyHealth.setOpaque(true);
		enemyHealth.setFont(new Font("Minion Pro Cond", Font.PLAIN, 12));

		fight.setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("background3.jpg"));

		JLabel notification = new JLabel();
		notification.setBounds(0, 375, 630, 230);
		notification.setVisible(false);

		//Add the labels, Buttons, background to window
		background.add(notifConfirm);
		background.add(notification);
		background.add(playerHealth);
		background.add(enemyHealth);
		background.add(run);
		background.add(attack);
		background.add(heal);
		
		// Automate with random selection
		background.add(enemies.enemy());
		fight.add(background);

		// Just for refresh
		fight.setSize(629, 629);
		fight.setSize(630, 630);

		// BUTTON CLICKS
		run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fight.dispose();
				MainMenu.mainMenu();
			}
		});

		// Attack button being clicked
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerHp <= 0) {
					fight.dispose();
					playerHp = playerClass.playerHlth;
					playerData.playerlives = playerData.playerlives - 1;
					run.setVisible(false);
					heal.setVisible(false);
					attack.setVisible(false);
					fight.dispose();

					JFrame dead = new JFrame("Game");
					dead.setTitle("fight");
					dead.setSize(250, 125);
					dead.setLocationRelativeTo(null);
					dead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dead.setVisible(true);
					dead.setResizable(false);
					JButton b7 = new JButton("You Died");
					b7.setLayout(new BorderLayout());

					dead.add(b7);

					// This checks to see if the button was clicked
					b7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							b7.setVisible(false);
							dead.dispose();

							MainMenu.mainMenu();
						}
					});

				}

				enemyHp = enemyHp - damg;

				//Check enemy Health
				if (enemyHp > 0) {
					Random rand = new Random();
					int enemyOpt = rand.nextInt(100) + 1;
					
					//If random selection for enemy turn is less than 75, have the enemy attack 
					if (enemyOpt <= 75) {
						playerHp = playerHp - enemyDmg;
						playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
								+ "</pre></html>");
						enemyHealth.setText(
								"<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth() + "</pre></html>");
						enemyHeal = false;

						//If player dies, end game
						if (playerHp <= 0) {
							
							fight.dispose();
							playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
									+ "</pre></html>");
							enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
									+ "</pre></html>");
							playerHp = playerClass.playerHlth;
							enemyHeal = false;
							playerData.playerlives = playerData.playerlives - 1;
							JFrame dead = new JFrame("Game");
							dead.setTitle("fight");
							dead.setSize(250, 125);
							dead.setLocationRelativeTo(null);
							dead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							dead.setVisible(true);
							dead.setResizable(false);
							JButton b7 = new JButton("You Died");
							b7.setLayout(new BorderLayout());
							dead.add(b7);

							b7.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									b7.setVisible(false);
									dead.dispose();
									fight.dispose();
									MainMenu.mainMenu();
								}
							});

						}
					}

					//If enemy option is 76 or greater, enemy heals. Depending on enemy health they either gain, do nothing
					// or get set back to original health
					else if (enemyOpt >= 76) {
						if (enemyHp == enemies.health) {
							playerHp = playerHp - enemyDmg;
							playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
									+ "</pre></html>");
							enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
									+ "</pre></html>");
							enemyHeal = true;
						}

						else if (enemyHp < enemies.health) {
							if (enemyHp + 20 > enemies.health) {
								enemyHp = enemies.health;
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
								enemyHeal = true;
							}

							else {
								enemyHp = enemyHp + 20;
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
								enemyHeal = true;
							}
						}
					}
				}

				//Hide the buttons
				run.setVisible(false);
				heal.setVisible(false);
				attack.setVisible(false);
				notification.setOpaque(true);
				notification.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
				notifConfirm.setVisible(true);

				//Show notification with damage dealt in the turn
				notification.setVisible(true);
				if (enemyHeal) {
					notification.setText(
							"<html><pre>You attacked for " + damg + "\n" + "The enemy healed" + "</pre></html>");
				} else {
					notification.setText("<html><pre>You attacked for " + damg + "\n" + "The enemy hit you \n for "
							+ enemyDmg + " health </pre></html>");
				}

				notifConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Once button is clicked, show the buttons again and hide the notification
						notifConfirm.setVisible(false);
						notification.setVisible(false);
						run.setVisible(true);
						heal.setVisible(true);
						attack.setVisible(true);

						//Check to see if player killed enemy
						//If killed hide fight window and tell them they win
						if (enemyHp <= 0) {
							fight.dispose();
							if (enemyHp <= 0) {
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
								kills++;
								enemyHp = enemies.health;
								playerData.playergld = playerData.playergld + enemies.gold;
								xpGain = xpGain + enemies.xp;
								
								if (xpGain == 100) {
									plyrLvl++;
									totalxp = totalxp + xpGain;
									xpGain = 0;
									playerData.playerlvl = plyrLvl;
								}
								
								JFrame youWin = new JFrame("Game");
								youWin.setTitle("fight");
								youWin.setSize(250, 125);
								youWin.setLocationRelativeTo(null);
								youWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								youWin.setVisible(true);
								youWin.setResizable(false);
								JButton ok = new JButton("You Win");
								ok.setLayout(new BorderLayout());
								youWin.add(ok);

								ok.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										//Once this is clicked it will take them back to the main menu
										ok.setVisible(false);
										playerData.playergld = playerData.playergld + 50;
										classSelection.playerSave();
										youWin.dispose();
										fight.dispose();
										MainMenu.mainMenu();
									}
								});
							}
						}
					}
				});
			}
		});
		// Heal Button being clicked

		heal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Allows the player to heal
				if (playerHp == playerClass.playerHlth) {
					playerHealth.setText(
							"<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth + "</pre></html>");
					enemyHealth.setText(
							"<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth() + "</pre></html>");
				}

				else if (playerHp < playerClass.playerHlth) {
					if (playerHp + 20 > playerClass.playerHlth) {
						playerHp = playerClass.playerHlth;
						playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
								+ "</pre></html>");
						enemyHealth.setText(
								"<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth() + "</pre></html>");
					}

					else {
						playerHp = playerHp + 20;
						playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
								+ "</pre></html>");
						enemyHealth.setText(
								"<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth() + "</pre></html>");
					}
				}

				//Enemy turn
				//Does the same as the enemy turn above
				if (enemyHp > 0) {
					Random rand = new Random();
					int enemyOpt = rand.nextInt(100) + 1;
					
					if (enemyOpt <= 75) {
						playerHp = playerHp - enemyDmg;
						playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
								+ "</pre></html>");
						enemyHealth.setText(
								"<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth() + "</pre></html>");
					}

					else if (enemyOpt >= 76) {
						if (enemyHp == enemies.health) {
							playerHp = playerHp - enemyDmg;

							playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/" + playerData.playerHlth
									+ "</pre></html>");
							enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
									+ "</pre></html>");

							if (playerHp <= 0) {
								fight.dispose();
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
								playerHp = playerClass.playerHlth;
								enemyHeal = false;
								playerData.playerlives = playerData.playerlives - 1;

								JFrame dead = new JFrame("Game");
								dead.setTitle("fight");
								dead.setSize(250, 125);
								dead.setLocationRelativeTo(null);
								dead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								dead.setVisible(true);
								dead.setResizable(false);
								JButton b7 = new JButton("You Died");
								b7.setLayout(new BorderLayout());
								dead.add(b7);

								b7.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										b7.setVisible(false);
										dead.dispose();
										fight.dispose();
										MainMenu.mainMenu();
									}
								});

							}
						}

						else if (enemyHp < enemies.health) {
							if (enemyHp + 20 > enemies.health) {
								enemyHp = enemies.health;
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
							}

							else {
								enemyHp = enemyHp + 20;
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
							}
						}
					}
				}

				run.setVisible(false);
				heal.setVisible(false);
				attack.setVisible(false);
				notification.setOpaque(true);
				notification.setFont(new Font("Minion Pro Cond", Font.PLAIN, 32));
				notifConfirm.setVisible(true);

				//Notification is the same as above
				notification.setVisible(true);
				if (enemyHeal) {
					notification.setText("<html><pre>You healed \n The enemy healed" + "</pre></html>");
				} else {
					notification.setText(
							"<html><pre>You  healed \n The enemy hit you \n for " + enemyDmg + " health </pre></html>");
				}

				notifConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						notifConfirm.setVisible(false);
						notification.setVisible(false);
						run.setVisible(true);
						heal.setVisible(true);
						attack.setVisible(true);

						if (enemyHp <= 0) {
							fight.dispose();
							if (enemyHp <= 0) {
								playerHealth.setText("<html><pre>Player Health:\n" + playerHp + "/"
										+ playerData.playerHlth + "</pre></html>");
								enemyHealth.setText("<html><pre>Enemy Health:\n" + enemyHp + "/" + enemies.enemyHealth()
										+ "</pre></html>");
								kills++;
								enemyHp = enemies.health;
								playerData.playergld = playerData.playergld + enemies.gold;
								xpGain = xpGain + enemies.xp;
								
								if (xpGain == 100) {
									plyrLvl++;
									totalxp = totalxp + xpGain;
									xpGain = 0;
								}
								
								JFrame youWin = new JFrame("Game");
								youWin.setTitle("fight");
								youWin.setSize(250, 125);
								youWin.setLocationRelativeTo(null);
								youWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								youWin.setVisible(true);
								youWin.setResizable(false);
								JButton ok = new JButton("You Win");
								ok.setLayout(new BorderLayout());
								// b7.setBounds(125, 50, 75, 25);
								youWin.add(ok);

								ok.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										playerData.playergld = playerData.playergld + 50;
										classSelection.playerSave();
										ok.setVisible(false);
										youWin.dispose();
										fight.dispose();
										MainMenu.mainMenu();
									}
								});
							}
						}
					}
				});
			}
		});
	}
}

package Georgio;

import java.awt.Component;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class enemies {
        public static int health;
        public static int damage;
        public static int number;
        public static int xp;
        public static int gold;
        public static int baseBossHlth;
        public static int baseBossDmg;
        public static int baseBossMss; 
        
        public static void difficulty(String x) {

                if (x.equalsIgnoreCase("easy")) {
                        health = 100;
                        damage = 10;
                        number = 5;
                        xp = 20;
                        gold = 20;
                        
                        baseBossHlth = 500;
                        baseBossDmg = 40;
                        baseBossMss = 40;
                        // testing
                        System.out.println(health + " " + damage + " " + number);
                }

                else if (x.equalsIgnoreCase("normal")) {
                        health = 200;
                        damage = 20;
                        number = 10;
                        xp = 20;
                        gold = 40;

                        baseBossHlth = 750;
                        baseBossDmg = 50;
                        baseBossMss = 30;
                        // testing
                        System.out.println(health + " " + damage + " " + number);
                }

                else if (x.equalsIgnoreCase("hard")) {
                        health = 300;
                        damage = 30;
                        number = 15;
                        xp = 20;
                        gold = 50;
                        
                        baseBossHlth = 1000;
                        baseBossDmg = 60;
                        baseBossMss = 0;
                        // testing
                        System.out.println(health + " " + damage + " " + number);
                }

        }
        
        public static int enemyHealth ()
        {
                return health;
        }

        public static int enemyDamage ()
        {
                return damage;
        }
        
        public static int enemyNumber ()
        {
                return number;
        }
        
        public static int enemyXp ()
        {
                return xp;
        }
        
        public static int enemyGold ()
        {
                return gold;
        }
        
        public static int baseBossHlth ()
        {
                return baseBossHlth;
        }
        
        public static int baseBossDmg ()
        {
                return baseBossDmg;
        }
        
        public static int baseBossMss ()
        {
                return baseBossMss;
        }
        // ENEMIES
        public static Component enemy1() {
                JLabel e1 = new JLabel(new ImageIcon("e1.png"));
                e1.setBounds(250, 150, 440, 200);
                return e1;
        }

        public static Component enemy2() {
                JLabel e2 = new JLabel(new ImageIcon("e2.png"));
                e2.setBounds(350, 40, 250, 465);
                return e2;
        }

        public static Component enemy3() {
                JLabel e3 = new JLabel(new ImageIcon("e3.png"));
                e3.setBounds(270, 30, 485, 465);
                return e3;
        }

        public static Component enemy4() {
                JLabel e4 = new JLabel(new ImageIcon("e4.png"));
                e4.setBounds(250, 160, 440, 220);
                return e4;
        }

        public static Component enemy5() {
                JLabel e5 = new JLabel(new ImageIcon("e5.png"));
                e5.setBounds(170, 90, 440, 320);
                return e5;
        }

        public static Component enemy6() {
                JLabel e6 = new JLabel(new ImageIcon("e6.png"));
                e6.setBounds(220, 90, 440, 320);
                return e6;
        }

        public static Component enemy7() {
                JLabel e7 = new JLabel(new ImageIcon("e7.png"));
                e7.setBounds(220, 90, 440, 320);
                return e7;
        }

        public static Component enemy8() {
                JLabel e8 = new JLabel(new ImageIcon("e8.png"));
                e8.setBounds(220, 90, 440, 320);
                return e8;
        }

        public static Component enemy9() {
                JLabel e9 = new JLabel(new ImageIcon("e9.png"));
                e9.setBounds(220, 90, 440, 320);
                return e9;
        }

        public static Component enemy10() {
                JLabel e10 = new JLabel(new ImageIcon("e10.png"));
                e10.setBounds(220, 90, 440, 320);
                return e10;
        }

        public static Component enemy11() {
                JLabel e11 = new JLabel(new ImageIcon("e11.png"));
                e11.setBounds(220, 90, 440, 320);
                return e11;
        }
        
        public static Component boss1() {
                JLabel e11 = new JLabel(new ImageIcon("boss1.png"));
                e11.setBounds(220, 90, 440, 320);
                return e11;
        }
        
        public static Component enemy()
        {
                Component[] enemyPics = new Component[11];
                {
                enemyPics [0] = enemies.enemy1();
                enemyPics [1] = enemies.enemy2();
                enemyPics [2] = enemies.enemy3();
                enemyPics [3] =enemies.enemy4();
                enemyPics [4] = enemies.enemy5();
                enemyPics [5] = enemies.enemy6();
                enemyPics [6] = enemies.enemy7();
                enemyPics [7] = enemies.enemy8();
                enemyPics [8] = enemies.enemy9();
                enemyPics [9] = enemies.enemy10();
                enemyPics [10] = enemies.enemy11();
                }
                
                Random enemy = new Random();
                int enemyPicked = enemy.nextInt(11);
                System.out.println(enemyPicked);
                return enemyPics [enemyPicked];
        }
}

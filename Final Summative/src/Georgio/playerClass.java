package Georgio;

public class playerClass 
{
	public static int playerHlth;
	public static int playerDmg;
	public static int playerLvl;
	public static int playerGld;
	public static int playerlives;
	public static String name;
	
	public static void pClass(String x)
	{		
		if (x.equalsIgnoreCase("tank"))
		{
			playerHlth = 200;
			//DAMAGE IS 20
			playerDmg = 20;
			playerLvl = 1;
			playerGld = 0;
			playerlives = 3;
		}
		
		else if (x.equalsIgnoreCase("damage"))
		{
			playerHlth = 100;
			//DAMAGE IS 50
			playerDmg = 50;
			playerLvl = 1;
			playerGld = 0;
			playerlives = 3;
		}
		
		else if (x.equalsIgnoreCase("balance"))
		{
			playerHlth = 125;
			//DAMGE IS 30
			playerDmg = 30;
			playerLvl = 1;
			playerGld = 0;
			playerlives = 3;
		}
	}
}

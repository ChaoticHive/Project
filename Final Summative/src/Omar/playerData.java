package Omar;

import Georgio.items;

public class playerData {

	public static items weapon;
	public static items armor;
	public static String difficulty;
	public static int playerHlth;
	public static int playerlvl;
	public static int playerdmg;
	public static int playergld;
	public static int playerlives;
	
	public playerData (String x, items a, items b, int playerHlth2, int playerlvl2, 
			int playerdmg2, int playergld2, int playerlives2)
    {
		//Append Values
		difficulty = x;
		weapon = a;
        armor = b;
        playerHlth = playerHlth2;
        playerlvl = playerlvl2;
        playerdmg = playerdmg2;
        playergld = playergld2;
        playerlives = playerlives2;
        
    }

	
	public items playerWeapon ()
	{
		return weapon;
	}
	
	public items playerArmor ()
	{
		return armor;
	}
	
	public static String difficulty ()
	{
		return difficulty; 
	}
	
	public Object playerHealth ()
	{
		return playerHlth;
	}
	
	public static Object playerLvl ()
	{
		return playerlvl; 
	}
	
	public Object playerDmg ()
	{
		return playerdmg; 
	}
	
	public Object playerGld ()
	{
		return playergld; 
	}

	public Object playerlives ()
	{
		return playerlives; 
	}
	
	public playerData()
	{
		weapon = null;
		armor = null;
		playerHlth = 0;
		playerlvl = 0;
		playerdmg = 0;
		playergld = 0;
		playerlives = 3;		
	}
	
}

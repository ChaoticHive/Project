package Omar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Georgio.items;

public class playerInventory 
{

	public static void invWeapons(items[] x) 
	{
		String thisLine;
		int n = 0;
		try 
		{
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("player inventory weapons.txt"));

			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				//TEST
				String[] invtot = thisLine.split(", ");
				
				items n1 = new items(invtot[0], Integer.parseInt(invtot[1]),
						Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]));

				x[n] = n1;
				n++;
				
			}
			inv.close();
		} 
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
	}

	public static void saveInvWeapons(items[] x)
	{
		int i = 0;
		try {
			File filename = new File("player inventory weapons.txt");
			FileWriter outputWriter = new FileWriter(filename);
			while (x[i] != null)
			{
			outputWriter.write(x[i].itemName + ", " + x[i].itemDmg + ", " + x[i].itemHlth + ", " + x[i].itemGold +
					"\r\n");
			i++;
			}
			outputWriter.flush();
			outputWriter.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void invArmor(items[] x)
	{
		String thisLine;
		int n = 0;
		try {
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("player inventory armor.txt"));

			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				String[] invtot = thisLine.split(", ");
				
				
				items n1 = new items(invtot[0], Integer.parseInt(invtot[1]),
						Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]));

				x[n] = n1;
				n++;
				
			}
			inv.close();
		} 
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
	}
	
	public static void saveInvArmor(items[] x)
	{
		int i = 0;
		try {
			File filename = new File("player inventory armor.txt");
			FileWriter outputWriter = new FileWriter(filename);
			while (x[i] != null)
			{
			outputWriter.write(x[i].itemName + ", " + x[i].itemDmg + ", " + x[i].itemHlth + ", " + x[i].itemGold +
					"\r\n");
			i++;
			}
			outputWriter.flush();
			outputWriter.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void shopWeapons(items[] x)
	{
		String thisLine;
		int n = 0;
		try {
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("shop weapons.txt"));

			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				String[] invtot = thisLine.split(", ");
				
				items n1 = new items(invtot[0], Integer.parseInt(invtot[1]),
						Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]));

				x[n] = n1;
				n++;
				
			}
			inv.close();
		} 
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
	}
	
	public static void saveShopWeapons(items[] x)
	{
		int i = 0;
		try {
			File filename = new File("shop weapons.txt");
			FileWriter outputWriter = new FileWriter(filename);
			while (x[i] != null)
			{
				if (x[i].itemName.equals("Sold"))
				{
				}
				else
				{
					outputWriter.write(x[i].itemName + ", " + x[i].itemDmg + ", " + x[i].itemHlth + ", " + x[i].itemGold + 
							"\r\n");
				}
				i++;
			}
		
			outputWriter.flush();
			outputWriter.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void shopArmor(items[] x)
	{
		String thisLine;
		int n = 0;
		try {
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("shop armor.txt"));

			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				String[] invtot = thisLine.split(", ");
				
				items n1 = new items(invtot[0], Integer.parseInt(invtot[1]),
						Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]));

				x[n] = n1;
				n++;
				
			}
			inv.close();
		} 
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
	}
	
	public static void saveShopArmor(items[] x)
	{
		int i = 0;
		try {
			File filename = new File("shop armor.txt");
			FileWriter outputWriter = new FileWriter(filename);
			while (x[i] != null)
			{
				if (x[i].itemName.equals("Sold"))
				{
				}
				else
				{
					outputWriter.write(x[i].itemName + ", " + x[i].itemDmg + ", " + x[i].itemHlth + ", " + x[i].itemGold + 
							"\r\n");
				}
				i++;
			}
		
			outputWriter.flush();
			outputWriter.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void newShopArmor(items[] x)
	{
		String thisLine;
		int n = 0;
		try {
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("Armour.txt"));

			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				String[] invtot = thisLine.split(", ");
				
				items n1 = new items(invtot[0], Integer.parseInt(invtot[1]),
						Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]));

				x[n] = n1;
				n++;
				
			}
			inv.close();
		} 
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
	}
	
	public static void newShopWeapons(items[] x)
	{
		String thisLine;
		int n = 0;
		try {
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("weapons.txt"));

			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				String[] invtot = thisLine.split(", ");
				
				items n1 = new items(invtot[0], Integer.parseInt(invtot[1]),
						Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]));

				x[n] = n1;
				n++;
				
			}
			inv.close();
		} 
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
	}
}
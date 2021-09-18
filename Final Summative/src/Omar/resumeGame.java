package Omar;
import java.io.*;
import Georgio.enemies;
import Georgio.items;

public class resumeGame 
{

	public static playerData resume;

	public static playerData resume()
	{
		//Resume the old game that was created
		String thisLine;
		try 
		{
			// Initialize Reader
			BufferedReader inv = new BufferedReader(new FileReader("SaveData.txt"));
			System.out.println("Test");
			// Setup Array
			while ((thisLine = inv.readLine()) != null) 
			{
				
				String[] invtot = thisLine.split(", ");
				playerData.difficulty = invtot[0];
				playerData.weapon = new items(invtot[1], Integer.parseInt(invtot[2]), Integer.parseInt(invtot[3]),
						Integer.parseInt(invtot[4]));
				playerData.armor = new items(invtot[5], Integer.parseInt(invtot[6]), Integer.parseInt(invtot[7]),
						Integer.parseInt(invtot[8]));
				playerData.playerHlth = Integer.parseInt(invtot[9]);
				playerData.playerlvl = Integer.parseInt(invtot[10]);
				playerData.playerdmg = Integer.parseInt(invtot[11]);
				playerData.playergld = Integer.parseInt(invtot[12]);
				playerData.playerlives = Integer.parseInt(invtot[13]);
				
				enemies.difficulty(invtot[0]);
			}
			inv.close();
		}
		catch (Exception e) 
		{
			System.out.print("Exception error (did not write)  --->   ");
			System.out.println(e);
		}
		return resume;
	}
}

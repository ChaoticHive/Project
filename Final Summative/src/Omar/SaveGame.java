package Omar;

import java.io.*;

public class SaveGame {
	public static void save(playerData x) {
		// Save player data
		try {
			File filename = new File("SaveData.txt");
			FileWriter outputWriter = new FileWriter(filename);
			outputWriter.write(playerData.difficulty + ", " + playerData.weapon.itemName + ", " 
					+ playerData.weapon.itemDmg + ", " + playerData.weapon.itemHlth + ", " 
					+ playerData.weapon.itemGold + ", " + playerData.armor.itemName + ", " 
					+ playerData.armor.itemDmg + ", " + playerData.armor.itemHlth + ", " 
					+ playerData.armor.itemGold + ", " + playerData.playerHlth + ", " 
					+playerData.playerlvl + ", " + playerData.playerdmg + ", " 
					+ playerData.playergld + ", " + playerData.playerlives);

			outputWriter.flush();
			outputWriter.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
}
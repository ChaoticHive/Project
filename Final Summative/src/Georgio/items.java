package Georgio;

public class items 
{
	public String itemName;
    public int itemDmg;
    public  int itemHlth;
    public  int itemGold;

    public items (String x, int n, int y, int z)
    {
        itemName = x;
        itemDmg = n;
        itemHlth = y;
        itemGold = z;
    }

    public items ()
    {
        itemName = "None";
        itemDmg = 0;
        itemHlth = 0;
        itemGold = 0;
    }

    public String getItemName ()
    {
        return itemName;
    }


    public int getItemDmg ()
    {
        return itemDmg;
    }

    public int getItemHlth ()
    {
        return itemHlth;
    }

    public int getItemGold ()
    {
        return itemGold;
    }
}

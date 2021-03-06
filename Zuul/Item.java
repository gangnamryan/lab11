import java.util.Random;
/**
 * The Item class stores information about items that the player can pick up
 *
 * @author Alex Thorsrud & Nash
 * @version 12.12.18
 */
public class Item
{
    private String itemName;
    private String itemDesc;
    private String itemColor;
    private boolean genRarity;
    private int itemRarity;
    
    /**
     * Simple constructor for objects of class Item
     */
    public Item(String name, String desc)
    {
        itemName = name;
        itemDesc = desc;
    }
    
    /**
     * Complex constructor for objects of class Item
     */
    public Item(String name, String desc, String color, boolean rarity)
    {
        itemName = name;
        itemDesc = desc;
        itemColor = color;
        genRarity = rarity;
        if(genRarity){Random rand=new Random(); itemRarity = rand.nextInt(5)+1;}
    }

    /**
     * Accessor for item name
     *
     * @return String, item name
     */
    public String getName()
    {
        // put your code here
        return itemName;
    }
    /**
     * Accessor for item description
     * 
     * @return String, item description
     */
    public String getDesc()
    {
        return itemDesc;
    }
    /**
     * Accessor for item color
     * 
     * @return String, item color
     */
    public String getColor()
    {
        return itemColor;
    }
    /**
     * Accessor for item rarity
     * 
     * @return Int, item rarity (if item initialized with rarity) 
     */
    public int getRarity()
    {
        if(genRarity){return itemRarity;}
        return -1;
    }
    
}

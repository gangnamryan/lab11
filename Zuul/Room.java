import java.util.*;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author Alex Thorsrud & Nash
 * @version 1.0 (February 2002)
 */
public class Room 
{
    private String description; //description of the room
    private HashMap<String, Room> exits;
    private Item item;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param rmdesc the description of the room
     */
    public Room(String rmdesc) 
    {
        description = rmdesc;
        exits = new HashMap<String,Room>();
    }

    /**
     * Define one exit of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction the direction of the exit
     * @param room the Room that lies in that direction
     */
    public void setExit(String direction, Room room) {
        exits.put(direction,room);
    }

    /**
     * Return the room that lies in the indicated direction, or null if there
     * is no exit in that direction.
     * @param direction the direction of the exit
     * @return the Room that lies in that direction
     */
    public Room getExit(String direction) {
        return exits.get(direction);

    }

    public String getExitString() {
        String exitString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            exitString+=exit + " ";
        }
        if(exitString.equals("Exits: ")) {
            exitString+="none.";
        }
        return exitString;
    }
    //write name of room, its exits
    public String getLongDescription() {
        String longString="You are in " + getDescription() + "\n" + getExitString() + "\n";
        if (hasItem()) {
            longString+=("Items: This room has a " + getItem().getName());
        } else {
            longString+="Items: This room has no items.";
        }
        return longString;
    }

    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }

    public boolean hasItem() {
        return (item != null);
    }

    public void addItem(Item theItem) {
        if (!hasItem()) {
            this.item=theItem;
        }
    }

    public void removeItem() {
        if (hasItem()) {
            item=null;
        }
    }

    public Item getItem() {
        if (hasItem()) {
            return item;
        } else { return null; }
    }

    public String getItemDisplayString() {
        if (hasItem()) {
            return ("Items: This room has a " + getItem().getName() + ". It does: " + getItem().getDesc());
        } else {
            return "Items: This room has no items.";
        }
    }
}


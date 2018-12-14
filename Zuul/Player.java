import java.util.ArrayList;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class represents a player of the Zuul game.  It keeps track of the
 * player's name and current location, and implements methods corresponding
 * to actions that the player can take.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author  Tim Wahls
 * @author  Grant Braught
 * @version 3.0 (November 2006)
 */
public class Player
{
    private String name;
    private Room currentRoom; // current location of the player
    private ArrayList<Item> inventory; 
    /**
     * Create a new Player with the specified name and initial location
     * @param name the name of the player
     * @param initRoom the initial location of the player
     */
    public Player(String name, Room initRoom)
    {
        this.name = name;
        currentRoom = initRoom;
        inventory = new ArrayList<Item>();
    }

    /**
     * Get the name of the player
     * @return the name of the player 
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the current room of the player
     * @return the current room of the player
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room and return true.  If there is no exit, stay in the
     * same room and return false.
     * @param direction the direction to go
     */
    public boolean goRoom(String direction) 
    {
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            return false;
        } else {
            currentRoom = nextRoom;
            return true;
        }
    }
    //takes a string as input and returns the item associated with that string
    public Item matchName(String itemName)
    {
        for(int i=0; i<inventory.size(); i++)
        {
            if(inventory.get(i).getName().equals(itemName))
            {
                return inventory.get(i);
            }	
        }return null;
    }

    public void takeItem(Item item)
    {
        if (!currentRoom.hasItem()) {
            System.out.println("there is no item in this room!");
            return;
        }
        inventory.add(item);
    }	

    public void dropItem(Item item)
    {
        for(int i=0; i<inventory.size(); i++) {
            if(!currentRoom.hasItem()) {
                if(inventory.get(i).equals(item))
                {
                    currentRoom.addItem(inventory.get(i));
                    inventory.remove(i);
                }   
            } else {
                System.out.println("Error: Room already has an item!");
            }
        }
    }

    public String inventoryToString() {
        String inventoryString="In your inventory: ";
        for(Item item : inventory) {
            inventoryString+=item.getName() + " ";
        }
        return inventoryString;
    }

}

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
    private double maxWeight;
    /**
     * Create a new Player with the specified name and initial location
     * @param name the name of the player
     * @param initRoom the initial location of the player
     */
    public Player(String name, Room initRoom, double maxWeight)
    {
        this.name = name;
        currentRoom = initRoom;
	this.maxWeight = maxWeight;
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

    public double currentBurden()
    {
	double currentBurden=0;
	for(int i=0; i<inventory.size(); i++){
    		currentBurden+=inventory.get(i).getWeight();
	} return currentBurden;
    }

    public void takeItem(Item item)
    {
	inventory.add(item);
	if(!(currentBurden()<maxWeight)){
		inventory.remove(inventory.size() -1);
	}	
    }

    public void dropItem(Item item)
    {
	for(int i=0; i<inventory.size(); i++)
	{
		if(inventory.get(i).equals(item))
		{
			currentRoom.addItem(inventory.get(i));
			inventory.remove(i);
		}	
	}
    }
}

import java.util.HashMap;
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
    private HashMap<String, Room> exits
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param rmdesc the description of the room
     */
    public Room(String rmdesc) 
    {
        description = rmdesc;
    }

    /**
     * Define one exit of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction the direction of the exit
     * @param exit the Room that lies in that direction
     */
    public void setExit(Room north, Room east, Room south, Room west, Room up, Room down) {
		if(north != null){
			exits.put("north", north);
		} else if(east != null){
			exits.put("east", east);
		} else if(south != null){
			exits.put("south", south);
		} else if(west != null){
			exits.put("west", west);
		} else if(up != null){
			exits.put("up", up);
		} else if(down != null){
			exits.put("down", down);
		}
    }
    
    /**
     * Return the room that lies in the indicated direction, or null if there
     * is no exit in that direction.
     * @param direction the direction of the exit
     * @return the Room that lies in that direction
     */
    public Room getExit(String direction) {
        return
        }
    }
    public String getExitString() {
        String exits="";
        if (getExit("north") != null) {
            exits+="north";
        }
        if (getExit("west") != null) {
            exits+="west";
        }
        if (getExit("south") != null) {
            exits+="south";
        }
        if (getExit("east") != null) {
            exits+="east";
        }
        return exits;
    }
    //write name of room, its exits
    public void getLongDescription() {
        System.out.println("You are " + getDescription());
	System.out.print("Exits: ");
	getExitString();
	System.out.println();
    }
    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }
    public void getLongDescription() {
	Room currentRoom = thePlayer.getCurrentRoom();
	System.out.println("You are " + currentRoom.getDescription());
	System.out.print("Exits: ");
	currentRoom.getExitString();
	System.out.println();
	}
}


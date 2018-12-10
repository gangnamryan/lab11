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
    private Room northExit; //exit to the north 
    private Room southExit; //exit to the south
    private Room eastExit;  //exit to the east
    private Room westExit;  //exit to the west 

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
    public void setExit(String direction, Room exit) 
    {
        if (direction.equals("north")) {
            northExit = exit;
        } 
        else if (direction.equals("east")) {
            eastExit = exit;
        } 
        else if (direction.equals("south")) {
            southExit = exit;
        } 
        else if (direction.equals("west")) {
            westExit = exit;
        }
    }
    
    /**
     * Return the room that lies in the indicated direction, or null if there
     * is no exit in that direction.
     * @param direction the direction of the exit
     * @return the Room that lies in that direction
     */
    public Room getExit(String direction) {
        if (direction.equals("north")) {
            return northExit;
        } 
        else if (direction.equals("east")) {
            return eastExit;
        } 
        else if (direction.equals("south")) {
            return southExit;
        } 
        else if (direction.equals("west")) {
            return westExit;
        } 
        else {
            return null;
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
        
    }
    /**
     * Return the description of the room (the one that was defined
     * in the constructor).
     */
    public String getDescription()
    {
        return description;
    }
}


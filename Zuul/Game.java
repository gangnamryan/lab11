/**
 *  This class is the main class of the "World of Commerce" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @author Tim Wahls
 * @author Grant Braught
 * @author (YOUR NAME HERE)
 * @version 3.0 (November 2006)
 */

public class Game 
{
    private CommandReader reader;
    private Player thePlayer;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRoomsAndPlayer();
        reader = new CommandReader();
        reader.addCommand("go");
        reader.addCommand("quit");
        reader.addCommand("help");
    }
    
    /**
     * Create all the rooms and link their exits together.  Also, create
     * the player and set the player's initial room.
     */
    public void createRoomsAndPlayer()
    {
        // create the rooms
        Room outdoors_store = new Room("buy shoes for outside");
        Room theatre_store = new Room("buy wigs");
        Room bigroom = new Room("the big empty area outside the stores");
        Room outside = new Room("the world outside the mall");
        Room heaven = new Room("youve lived a good life");
        Room hell = new Room("you will burn");
        
        // initialise room exits
        bigroom.setExit("south", outside);
        bigroom.setExit("west", outdoors_store);
        outdoors_store.setExit("east", bigroom);
        bigroom.setExit("west", outdoors_store);
                                                                                
        thePlayer = new Player("Zed", outside);  // start game outside
    }
    
    /**
     * Return the player
     * @return the player
     */
    public Player getPlayer() {
        return thePlayer;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (!finished) {
            Command command = reader.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
      
    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Commerce");
        System.out.println("World of Commerce is an old and idiotic adventure game.");
        System.out.println("Type 'help' if you need help (you probably do).");
        System.out.println();
        printDirections();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param command the command to process
     */
    public boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if (command == null) {
            System.out.println("I don't know what you mean ...");
            return false;
        } else {
            String commandWord = command.getCommandWord();
            if (commandWord.equals("help")) {
                printHelp();
            } else if (commandWord.equals("go")) {
                goRoom(command);
            } else if (commandWord.equals("quit")) {
                wantToQuit = quit(command);
            }
        }
        
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * @param command the "go" command
     */
    public void goRoom(Command command) 
    {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
        } else {
            String direction = command.getSecondWord();

            // Try to leave current room.
            boolean hasLeft = thePlayer.goRoom(direction);

            if (!hasLeft) {
                System.out.println("There is no door!");
            } else {
                printDirections();
            }
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     * @param command the "quit" command
     */
     public void printDirections() {
	Room currentRoom = thePlayer.getCurrentRoom();
	currentRoom.getLongDescription();
	}
    public boolean quit(Command command) 
    {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    public void main() {
		printWelcome();
		boolean finished=false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("later idiot");
	}
}

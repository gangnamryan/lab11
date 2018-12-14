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
 * @author Alex Thorsrud & Nash
 * @version 3.0 (November 2006)
 */

public class Game 
{

    private static final String NORTH = "north";
    private static final String WEST = "west";
    private static final String EAST = "east";
    private static final String SOUTH = "south";
    private static final String UPTHANKUWEBCAT = "up";
    private static final String DOWN = "down";

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
        reader.addCommand("take");
        reader.addCommand("inventory");
        reader.addCommand("drop");
    }

    /**
     * Create all the rooms and link their exits together.  Also, create
     * the player and set the player's initial room.
     */
    public void createRoomsAndPlayer()
    {
        // create the rooms
        //
        Room outdoorsStore = new Room("buy shoes for outside");
        Room theatreStore = new Room("buy wigs");
        Room phoneStore = new Room("for phone");
        Room bigRoom = new Room("the big empty area outside the stores");
        Room outside = new Room("the world outside the mall");
        Room heaven = new Room("youve lived a good life");
        Room hell = new Room("you will burn");

        // initialise room exits
        //  public void setExit(Room north, Room west, Room east, Room south, Room up, Room down) {

        //                      north           west            east            south       up      down
        bigRoom.setExit(NORTH, theatreStore);
        bigRoom.setExit(WEST, outdoorsStore);
        bigRoom.setExit(EAST, phoneStore);
        bigRoom.setExit(SOUTH, outside);
        
        theatreStore.setExit(SOUTH,bigRoom);
        outdoorsStore.setExit(EAST,bigRoom);
        phoneStore.setExit(WEST, bigRoom);
        outside.setExit(NORTH, bigRoom);
		
		bigRoom.setExit(UPTHANKUWEBCAT, heaven);
        bigRoom.setExit(DOWN, hell);
		theatreStore.setExit(UPTHANKUWEBCAT, heaven);
		theatreStore.setExit(DOWN, heaven);
		phoneStore.setExit(UPTHANKUWEBCAT, heaven);
		phoneStore.setExit(DOWN, heaven);
		outside.setExit(UPTHANKUWEBCAT, heaven);
		outside.setExit(DOWN, heaven);

        
        //public Item(String name, String desc, double weight, String color, boolean rarity)
        theatreStore.addItem(new Item("theatre_bag", "holds your shame", 20, "green", true));
        outdoorsStore.addItem(new Item("outdoors_bag", "holds things from the outdoors store", 15, "blue", true));
        phoneStore.addItem(new Item("phone_bag", "this bag holds a phone", 15, "red", true));
        bigRoom.addItem(new Item("big_bag", "this bag holds other bags", 0, "magenta", false));
        heaven.addItem(new Item("happy_token", "you have made it to and from heaven", 0, "yellow", false));
        hell.addItem(new Item("burnt_clothes", "you've escaped hell", 0, "black", false));

        CommandReader parser = new CommandReader();
        thePlayer = new Player("Zed", outside, 100);  // start game outside
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
        Room currentRoom=thePlayer.getCurrentRoom();
        if (command == null) {
            System.out.println("I don't know what you mean ...");
            return false;
        } else {
            String commandWord = command.getCommandWord();
            String secondWord = command.getSecondWord();

            if (commandWord.equals("help")) {
                printHelp();
            } else if (commandWord.equals("go")) {
                goRoom(command);
            } else if (commandWord.equals("quit")) {
                wantToQuit = quit(command);
            } else if (commandWord.equals("take")) {
                thePlayer.takeItem(currentRoom.getItem());
                currentRoom.removeItem();
            } else if (commandWord.equals("inventory")) {
                System.out.println(thePlayer.inventoryToString());
            } else if (commandWord.equals("drop")) {
                thePlayer.dropItem(thePlayer.matchName(secondWord));
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
        System.out.println(reader.allCommands());
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

    
    public void printDirections() {
        Room currentRoom = thePlayer.getCurrentRoom();
        System.out.println(currentRoom.getLongDescription());
    }
     /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     * @param command the "quit" command
     */
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
}

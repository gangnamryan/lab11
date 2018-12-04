

/**
 * The test class GameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameTest extends junit.framework.TestCase
{
	private Game game1;

    /**
     * Default constructor for test class GameTest
     */
    public GameTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
		game1 = new Game();
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

	public void testDefaultConstructor()
	{
		Room room1 = game1.getPlayer().getCurrentRoom();
		assertEquals("outside the main entrance of the university", room1.getDescription());
	}


	public void testPrintWelcome()
	{
		game1.printWelcome();
	}

	public void testPrintHelp()
	{
		game1.printHelp();
	}

	public void testProcessCommandNull()
	{
		assertEquals(false, game1.processCommand(null));
	}

	public void testProcessCommandHelp()
	{
		Command command1 = new Command("help", null);
		assertEquals(false, game1.processCommand(command1));
	}

	public void testProcessCommandGo()
	{
		Command command1 = new Command("go", "north");
		assertEquals(false, game1.processCommand(command1));
	}

	public void testProcessCommandQuit()
	{
		Command command1 = new Command("quit", null);
		assertEquals(true, game1.processCommand(command1));
	}

	public void testGoRoomNoDirection()
	{
		Command command1 = new Command("go", null);
		game1.goRoom(command1);
		Room room1 = game1.getPlayer().getCurrentRoom();
		assertEquals("outside the main entrance of the university", room1.getDescription());
	}	
	
	public void testGoRoomInvalidDirection()
	{
		Command command1 = new Command("go", "left");
		game1.goRoom(command1);
		Room room1 = game1.getPlayer().getCurrentRoom();
		assertEquals("outside the main entrance of the university", room1.getDescription());
	}
	
	public void testGoRoomValid()
	{
		Command command1 = new Command("go", "north");
		game1.goRoom(command1);
		Room room1 = game1.getPlayer().getCurrentRoom();
		assertEquals("in the HUB", room1.getDescription());
	}

	public void testQuit()
	{
		Command command1 = new Command("quit", null);
		assertEquals(true, game1.quit(command1));
	}

	public void testQuitError()
	{
		Command command1 = new Command("quit", "smoking");
		assertEquals(false, game1.quit(command1));
	}
}
















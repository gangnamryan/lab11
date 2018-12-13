

/**
 * The test class PlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest extends junit.framework.TestCase
{

    private Player thePlayer;
    
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        Room outside;
        Room theatre;
        Room pub;
        Room lab;
        Room office;
        Room hub;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        hub = new Room("in the HUB");
        
        
                                                                                
        thePlayer = new Player("Zed", outside, 100);  
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    public void testConstructor() {
        assertEquals(thePlayer.getName(), "Zed");
        assertEquals(thePlayer.getCurrentRoom().getDescription(),
                     "outside the main entrance of the university");
    }
    
	public void testGoRoomNorth()
	{
		thePlayer.goRoom("north");
		Room room1 = thePlayer.getCurrentRoom();
		assertEquals("in the HUB", room1.getDescription());
	}

	public void testGoRoomEast()
	{
		thePlayer.goRoom("east");
		Room room1 = thePlayer.getCurrentRoom();
		assertEquals("in a lecture theatre", room1.getDescription());
	}

	public void testGoRoomSouth()
	{
		thePlayer.goRoom("south");
		Room room1 = thePlayer.getCurrentRoom();
		assertEquals("in a computing lab", room1.getDescription());
	}

	public void testGoRoomWest()
	{
		thePlayer.goRoom("west");
		Room room1 = thePlayer.getCurrentRoom();
		assertEquals("in the campus pub", room1.getDescription());
	}

	public void testGoRoomInvalid()
	{
		thePlayer.goRoom("left");
		Room room1 = thePlayer.getCurrentRoom();
		assertEquals("outside the main entrance of the university",
		             room1.getDescription());
	}    
}

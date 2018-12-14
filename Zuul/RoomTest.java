
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RoomTest
{
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestConstructor()
    {
        Room room1 = new Room("first room");
        assertEquals("first room", room1.getDescription());
        assertEquals(false, room1.hasItem());
    }

    @Test
    public void TestAddItem()
    {
        Room room1 = new Room("first room");
        assertEquals("first room", room1.getDescription());
        assertEquals(false, room1.hasItem());
        assertEquals(null, room1.getItem());
        Item item1 = new Item("item1", "desc1", 10);
        Item item2 = new Item("item2", "desc2", 10);
        room1.addItem(item1);
        assertEquals(true, room1.hasItem());
        assertEquals(item1, room1.getItem());
        room1.addItem(item2);
        assertEquals(item1, room1.getItem());
    }

    @Test
    public void TestSetExit() {
        Room room1 = new Room("room1");
        Room room2 = new Room("room2");
        room1.setExit("north", room2);
        room1.getExit("north");

    }

    @Test
    public void TestGetExitString() {
        Room[] rooms = new Room[10];
        for(int i=0;i<10;i++)
            rooms[i]=new Room("room " + i);
        rooms[0].setExit("north", rooms[1]);
        rooms[0].setExit("west", rooms[2]);
        rooms[0].setExit("east", rooms[3]);
        rooms[0].setExit("south", rooms[4]);
        rooms[0].setExit("up", rooms[5]);
        rooms[0].setExit("down", rooms[6]);
        assertEquals("Exits: east south north west up down ", rooms[0].getExitString());
    }

    @Test
    public void TestGetLongDescription() {
        Room[] rooms = new Room[10];
        for(int i=0;i<10;i++)
            rooms[i]=new Room("room " + i);
        assertEquals("You are in room 0\nExits: none.\nItems: This room has no items.", rooms[0].getLongDescription());
        rooms[0].setExit("north", rooms[1]);
        rooms[0].setExit("west", rooms[2]);
        rooms[0].setExit("east", rooms[3]);
        rooms[0].setExit("south", rooms[4]);
        rooms[0].setExit("up", rooms[5]);
        rooms[0].setExit("down", rooms[6]);
    }


    @Test
    public void TestRemoveItem()
    {
        Room room1 = new Room("first room");
        assertEquals("first room", room1.getDescription());
        assertEquals(false, room1.hasItem());
        Item item1 = new Item("item1", "desc1", 10);
        room1.addItem(item1);
        assertEquals(true, room1.hasItem());
        room1.removeItem();
        assertEquals(false, room1.hasItem());
    }
}


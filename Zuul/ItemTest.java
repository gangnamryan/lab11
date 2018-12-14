

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
    /**
     * Default constructor for test class ItemTest
     */
    public ItemTest()
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
    public void testConstructor()
    {
        Item item1 = new Item("test", "test item");
        assertEquals(null, item1.getColor());
        assertEquals("test item", item1.getDesc());
        assertEquals("test", item1.getName());
        assertEquals(-1, item1.getRarity());
        Item item2 = new Item("rare_item", "testing with a rare item", "green", true);
        assertEquals("green", item2.getColor());
        assertEquals("testing with a rare item", item2.getDesc());
        assertEquals("rare_item", item2.getName());
    }
}


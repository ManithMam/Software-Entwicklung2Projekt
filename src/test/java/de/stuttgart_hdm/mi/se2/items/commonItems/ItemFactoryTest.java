package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class ItemFactoryTest {
    private Item rope;
    private Item cookBook;
    private Item glasses;

    @BeforeEach
    public void prepare(){
        rope = new Rope();
        cookBook = new Cookbook();
        glasses = new Glasses();
    }

    /**
     * Test to ensure unique item ID's, duplicates are not allowed
     */
    @Test
    public void testUniqueItemIds(){
        assertTrue(rope.getId() != cookBook.getId() && glasses.getId() != rope.getId() && glasses.getId() != cookBook.getId());
    }

    /**
     * Testing whether item parameters get assigned correctly
     */
    @Test
    public void testItemParameters(){
        assertTrue(rope.isPickable());
        assertEquals("Rope", rope.getName());
        assertEquals("A strong rope that could be useful later", rope.getDesc());
    }

    /**
     * Method to remove all objects created for testing purposes
     */
    @AfterEach
    //@Test
    /**
     * Adds test to ensure removal of test objects
     */
    public void Teardown(){
        rope = null;
        cookBook = null;
        glasses = null;
        /*
        assertNull(rope);
        assertNull(cookBook);
        assertNull(glasses);
        */
    }

}


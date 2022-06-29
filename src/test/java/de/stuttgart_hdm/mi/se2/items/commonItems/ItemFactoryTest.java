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

    //Creating objects only when test is conducted
    @BeforeEach
    public void prepare(){
        rope = new Rope();
        cookBook = new Cookbook();
        glasses = new Glasses();
    }

    //Testing whether each item has a unique ID, duplicate IDs not allowed
    @Test
    public void TestUniqueItemIds(){
        assertTrue(rope.getId() != cookBook.getId() && glasses.getId() != rope.getId() && glasses.getId() != cookBook.getId());
    }

    //Testing whether the items have the correct assigned parameters
    @Test
    public void TestItemParameters(){
        assertTrue(rope.isPickable());
        assertEquals(rope.getName(), "Rope");
        assertEquals(rope.getDesc(), "A strong rope that could be useful later");
    }

    //Removing the objects created for testing purposes
    @AfterEach
    //Testing whether Teardown method is working properly
    //@Test
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


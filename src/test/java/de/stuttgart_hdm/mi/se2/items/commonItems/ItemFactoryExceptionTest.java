package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryExceptionTest {

    private CommonItemFactory testItemFactory;
    private Item testItem;

    @BeforeEach
    public void setup(){
        testItemFactory = new CommonItemFactory();
    }

    /**
     * Testing whether IllegalArgumentException is thrown, when trying to create non defined item
     */
    @Test
    public void itemExceptionTest(){
        Throwable e = assertThrows(IllegalArgumentException.class, () -> testItem = testItemFactory.createItem("Test Item"));
        assertEquals("Item not existing", e.getMessage());
    }

    /**
     * Method to remove all objects created for testing purposes
     */
    @AfterEach
    //@Test
    /**
     * Adds test to ensure removal of test objects
     */
    public void teardown(){
        testItemFactory = null;
        testItem = null;
        /*
        assertNull(testItemFactory);
        assertNull(testItem);
        */
    }

}
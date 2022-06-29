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

    //Creating new Item factory only when test is conducted
    public void setup(){
        testItemFactory = new CommonItemFactory();
    }

    @Test
    //Testing whether Exception is thrown when trying to create a non existing Item
    public void itemExceptionTest(){
        Throwable e = assertThrows(IllegalArgumentException.class, () -> testItem = testItemFactory.createItem("Test Item"));
        assertEquals("Item not existing", e.getMessage());
    }

    @AfterEach
    //Removing the objects created for testing purposes
    //@Test
    //Testing whether objects have been removed
    public void teardown(){
        testItemFactory = null;
        testItem = null;
        /*
        assertNull(testItemFactory);
        assertNull(testItem);
        */
    }

}
package de.stuttgart_hdm.mi.se2.items.commonItems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemFactoryTest {
    BaseballBat baseballBat = new BaseballBat();
    Cookbook cookBook = new Cookbook();
    Glasses glasses = new Glasses();

    //Testing whether each item has a unique ID, duplicate IDs not allowed
    @Test
    public void TestUniqueItemIds(){
        ItemFactoryTest uniqueIdTest = new ItemFactoryTest();
        assertTrue(baseballBat.getId() != cookBook.getId() && glasses.getId() != baseballBat.getId() && glasses.getId() != cookBook.getId());
    }

    //Testing whether the items have the correct assigned parameters
    @Test
    public void TestItemParameters(){
        ItemFactoryTest parameterTest = new ItemFactoryTest();
        assertTrue(baseballBat.isPickable());
        assertEquals(baseballBat.getName(), "Baseball bat");
        assertEquals(baseballBat.getDesc(), "A strong negotiation device");
    }

}
package de.stuttgart_hdm.mi.se2.gui.model;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.CommonItemFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameModelTest {

    private GameModel gameModel;
    private CommonItemFactory commonItemFactory;

    @BeforeEach
    void before(){
        gameModel = new GameModel();
        commonItemFactory = new CommonItemFactory();
    }

    @Test
    void testPositivePickUp() throws IllegalArgumentException, IndexOutOfBoundsException {
        //Room Library
        gameModel.setCurrentRoom(gameModel.getRoomsList().get(3));
        //Item Book (can't use commonItemFactory because items have a unique id
        final Item item = gameModel.getCurrentRoom().getItemsInRoom().get(4);
        gameModel.pickUp(item, true);

        Assertions.assertTrue(!gameModel.getRoomsList().get(3).getItemsInRoom().contains(item) && gameModel.getInventory().contains(item));
        Assertions.assertEquals(1, gameModel.getInventory().size());
        Assertions.assertEquals(4, gameModel.getCurrentRoom().getItemsInRoom().size());


        gameModel.pickUp(item, false);

        Assertions.assertTrue(gameModel.getRoomsList().get(3).getItemsInRoom().contains(item) && !gameModel.getInventory().contains(item));
        Assertions.assertEquals(0, gameModel.getInventory().size());
        Assertions.assertEquals(5, gameModel.getCurrentRoom().getItemsInRoom().size());
    }

    @Test
    void testNegativePickUp() throws IllegalArgumentException, IndexOutOfBoundsException {
        //Room Kitchen
        gameModel.setCurrentRoom(gameModel.getRoomsList().get(2));
        final Item item = commonItemFactory.createItem("Book");

        Assertions.assertThrows(IllegalArgumentException.class, () -> gameModel.pickUp(item, true));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameModel.pickUp("test", true));
    }
}

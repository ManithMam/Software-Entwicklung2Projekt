package de.stuttgart_hdm.mi.se2.rooms;


import de.stuttgart_hdm.mi.se2.gui.model.GameModel;
import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.CommonItemFactory;

import static org.junit.jupiter.api.Assertions.*;

import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoomTest {

    private GameModel gameModel;
    private KeyItemFactory keyItemFactory;


    @Test
    public void testNeededItem() {
        RoomFactory roomFactory = new RoomFactory();
        gameModel = new GameModel();
        keyItemFactory = new KeyItemFactory();

        Room bathroom = roomFactory.createRoom("Bathroom");
        Room hallway = roomFactory.createRoom("Hallway");

        List item  = gameModel.getCurrentRoom().getKeyItemList().stream().filter(BaseballBat.class::isInstance).map(Item::getId).toList();

        assertEquals(item, bathroom.neededItem());

        gameModel.setCurrentRoom(gameModel.getRoomsList().get(3));
        item = new ArrayList();

        assertEquals(item, hallway.neededItem());
    }


    @Test
    public void testAddItemInRoom() {
        RoomFactory roomFactory = new RoomFactory();
        CommonItemFactory commonItemFactory = new CommonItemFactory();

        Room basement = roomFactory.createRoom("Basement");
        Room hallway = roomFactory.createRoom("Hallway");

        Item glasses = commonItemFactory.createItem("Glasses");
        Item rope = commonItemFactory.createItem("Rope");

        List<Item> itemInRoom;

        itemInRoom = basement.getItemsInRoom();
        itemInRoom.add(glasses);
        basement.addItemsInRoom(glasses);

        assertEquals(itemInRoom, basement.getItemsInRoom());


        itemInRoom = hallway.getItemsInRoom();
        itemInRoom.add(glasses);
        itemInRoom.add(rope);
        hallway.addItemsInRoom(glasses);
        hallway.addItemsInRoom(glasses);

        assertEquals(itemInRoom, hallway.getItemsInRoom());

    }

    @Test
    public void testCreatingRooms() {
        RoomFactory roomFactory = new RoomFactory();
        Room basement1 = roomFactory.createRoom("Basement");
        Room hallway1 = roomFactory.createRoom("Hallway");


        assertAll("id access name",
                () -> assertEquals(1, basement1.getId()),
                () -> assertEquals(false, basement1.getAccess()),
                () -> assertEquals("Basement", basement1.getName()));

        assertAll("id access name",
                () -> assertEquals(2, hallway1.getId()),
                () -> assertEquals(true, hallway1.getAccess()),
                () -> assertEquals("Hallway", hallway1.getName()));

    }

}

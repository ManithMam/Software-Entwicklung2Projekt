package de.stuttgart_hdm.mi.se2.rooms;


import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.CommonItemFactory;

import static org.junit.jupiter.api.Assertions.*;

import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoomTest {

    /*
    @Test
    public void testNeededItem() {
        RoomFactory roomFactory = new RoomFactory();
        KeyItemFactory keyItemFactory = new KeyItemFactory();

        Item baseBallBat = keyItemFactory.createItem("Baseball bat");
        Room bathroom = roomFactory.createRoom("Bathroom");
        Room basement = roomFactory.createRoom("Basement");
        Room hallway = roomFactory.createRoom("Hallway");

        List<Integer> hallwayList = new ArrayList<>();
        List<Integer> bathroomList = new ArrayList<>();
        List<Integer> basementList = new ArrayList<>();


        assertEquals(bathroomList, bathroom.neededItem());
        assertEquals(basementList, basement.neededItem());
        assertEquals(hallwayList, hallway.neededItem());
    }

     */

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
                () -> assertEquals(true, basement1.getAccess()),
                () -> assertEquals("Basement", basement1.getName()));

        assertAll("id access name",
                () -> assertEquals(2, hallway1.getId()),
                () -> assertEquals(true, hallway1.getAccess()),
                () -> assertEquals("Hallway", hallway1.getName()));

    }

    @Test
    public void negativeTestCreatingRooms() {
        RoomFactory roomFactory = new RoomFactory();
        Room basement1 = roomFactory.createRoom("Basement");


        assertAll("id access name",
                () -> assertEquals(1, basement1.getId()),
                () -> assertEquals(false, basement1.getAccess()),
                () -> assertEquals("Basement", basement1.getName()));

    }
}

package de.stuttgart_hdm.mi.se2.gui;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.ItemFactory;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import de.stuttgart_hdm.mi.se2.rooms.Room;
import de.stuttgart_hdm.mi.se2.rooms.RoomFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Model {

    private int roomIndex;
    private List<Room> roomsList;
    private List<Item> inventory;

    public static final Model model = new Model();


    private final Room startingRoom;
    private Room currentRoom;


    public Model()
    {
        this.roomIndex = 0;
        this.inventory = new ArrayList<Item>();


            final RoomFactory roomFactory = new RoomFactory();
            final Room basement = roomFactory.createRoom("Basement");                       //TODO: IllegalRuntimeException wird hier geworfen, daher noch fangen + logger informieren
            final Room hallway = roomFactory.createRoom("Hallway");
            final Room kitchen = roomFactory.createRoom("Kitchen");
            final Room library = roomFactory.createRoom("Library");
            final Room bathroom = roomFactory.createRoom("Bathroom");                       //TODO Logger informieren ?
            startingRoom = hallway;
            this.roomsList = new ArrayList<>();
            roomsList.add(hallway);
            roomsList.add(basement);
            roomsList.add(kitchen);
            roomsList.add(library);
            roomsList.add(bathroom);

            ItemFactory itemFactory = new ItemFactory();
            itemFactory.createAllItems();                                                           //TODO creieren wir das hier oder doch in Room-Subklassen ?
            KeyItemFactory keyItemFactory = new KeyItemFactory();
            keyItemFactory.createAllKeyItems();
            FurnitureFactory furnitureFactory = new FurnitureFactory();
            furnitureFactory.createAllFurniture();

    }

    public int getRoomIndex() {
        return this.roomIndex;
    }

    public void setRoomIndex(int index) {
        this.roomIndex = index;
    }

    public List<Room> getRoomsList()
    {
        return this.roomsList;
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public static Model getModel() {return model;}

}

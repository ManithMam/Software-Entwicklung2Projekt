package rooms;

import items.commonItems.ItemFactory;
import items.furniture.FurnitureFactory;
import items.keyItems.KeyItemFactory;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Room> roomsList;
    private final Room startingRoom;
    private Room currentRoom;

    public World()
    {
        RoomFactory roomFactory = new RoomFactory();
        Room basement = roomFactory.createRoom("Basement");
        Room hallway = roomFactory.createRoom("Hallway");
        Room kitchen = roomFactory.createRoom("Kitchen");
        Room library = roomFactory.createRoom("Library");
        Room bathroom = roomFactory.createRoom("Bathroom");
        startingRoom = hallway;
        roomsList = new ArrayList<>();
        roomsList.add(basement);
        roomsList.add(hallway);
        roomsList.add(kitchen);
        roomsList.add(library);
        roomsList.add(bathroom);

        ItemFactory itemFactory = new ItemFactory();
        itemFactory.createAllItems();
        KeyItemFactory keyItemFactory = new KeyItemFactory();
        keyItemFactory.createAllKeyItems();
        FurnitureFactory furnitureFactory = new FurnitureFactory();
        furnitureFactory.createAllFurniture();
    }

    public List<Room> getRoomsList()
    {
        return this.roomsList;
    }
}

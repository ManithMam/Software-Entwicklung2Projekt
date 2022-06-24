package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.ItemFactory;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import de.stuttgart_hdm.mi.se2.timer.Timer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private static final FurnitureFactory furnitureFactory = new FurnitureFactory();
    private static final KeyItemFactory keyItemFactory = new KeyItemFactory();
    private static final ItemFactory itemFactory = new ItemFactory();
    private static final List<Item> keyItemList = keyItemFactory.createAllKeyItems();
    private String name;
    private final List<Item> itemInRoom = new ArrayList<>();
    private String description;
    protected static int idCounter = 0;
    protected int id;
    private boolean access;

    private static final Logger log = LogManager.getLogger(Room.class);

    public FurnitureFactory getFurnitureFactory() {
        return furnitureFactory;
    }

    public KeyItemFactory getKeyItemFactory() {
        return keyItemFactory;
    }

    public static ItemFactory getItemFactory() {
        return itemFactory;
    }

    public static List<Item> getKeyItemList() {return keyItemList;}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean getAccess() {
        return this.access;
    }

    public List<Item> getItemsInRoom() {
        return itemInRoom;
    }

    public String getDescription() {
        return this.description;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public void addItemsInRoom(Item item) {

            if (!itemInRoom.contains(item) && item != null) {
                itemInRoom.add(item);
                log.info(item.getName() + " was added into the Room");
            }

    }

    public abstract int neededItem();           //TODO Exception werfen statt 0 ? --> muss dann gehandelt werden


    @Override
    public String toString() {
        return this.name;
    }
}

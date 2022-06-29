package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.CommonItemFactory;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Room {

    private static final FurnitureFactory furnitureFactory = new FurnitureFactory();
    private static final KeyItemFactory keyItemFactory = new KeyItemFactory();
    private static final CommonItemFactory COMMON_ITEM_FACTORY = new CommonItemFactory();
    //private static final List<Item> keyItemList = keyItemFactory.createAllKeyItems();
    private static final ObservableList<Item> keyItemList = keyItemFactory.createAllKeyItems();
    private String name;
    //private final List<Item> itemInRoom = new ArrayList<Item>();
    private final ObservableList<Item> itemInRoom = FXCollections.observableArrayList();
    private String description;
    private String doorDescription;
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

    public CommonItemFactory getItemFactory() {
        return COMMON_ITEM_FACTORY;
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

    public ObservableList<Item> getItemsInRoom() {
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


    public String getDoorDescription() {
        return doorDescription;
    }

    public void setDoorDescription(String doorDescription) {
        this.doorDescription = doorDescription;
    }


    public void setAccess(boolean access) {
        this.access = access;
    }

    //TODO throw exception
    public void addItemsInRoom(Item item) {

        if (!this.itemInRoom.contains(item) && item != null) {
            this.itemInRoom.add(item);
            log.info(item.getName() + " was succesfully added into the Room");
        }

    }

    /*
    //TODO throw exception
    public void removeItemInRoom(Object object) {
        Item item = (Item) object;

        if (!this.itemInRoom.contains(item) && item != null) {
            this.itemInRoom.remove(item);
            log.info(item.getName() + " was succesfully removed from the Room");
        }
    }

     */

    public abstract List<Integer> neededItem();


    @Override
    public String toString() {
        return this.name;
    }
}

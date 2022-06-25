package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.ItemFactory;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private static final FurnitureFactory furnitureFactory = new FurnitureFactory();
    private static final KeyItemFactory keyItemFactory = new KeyItemFactory();
    private static final ItemFactory itemFactory = new ItemFactory();
    //private static final List<Item> keyItemList = keyItemFactory.createAllKeyItems();
    private static final ObservableList<Item> keyItemList = keyItemFactory.createAllKeyItems();
    private String name;
    //private final List<Item> itemInRoom = new ArrayList<Item>();
    private final ObservableList<Item> itemInRoom = FXCollections.observableArrayList();
    private String description;
    protected static int idCounter = 0;
    protected int id;
    private boolean access;

    public FurnitureFactory getFurnitureFactory() {
        return furnitureFactory;
    }

    public KeyItemFactory getKeyItemFactory() {
        return keyItemFactory;
    }

    public static ItemFactory getItemFactory() {
        return itemFactory;
    }

    /*public static List<Item> getKeyItemList() {return keyItemList;}*/
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

    /*public List<Item> getItemsInRoom() {
        return itemInRoom;
    }*/
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

    public void setAccess(boolean access) {
        this.access = access;
    }

    protected void addItemsInRoom(Item item) {
        if (!itemInRoom.contains(item) && item != null) {
            itemInRoom.add(item);
            System.out.println("added item in room");
        }
    }

    public abstract List<Integer> neededItem();

    public String removeItem(Item item) {
        if (itemInRoom.contains(item) && item != null)
        {
            itemInRoom.remove(item);
            return "You picked up the Item";
        }
        return "You can't pick it up";
    }

    @Override
    public String toString() {
        return this.name;
    }
}

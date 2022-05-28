package rooms;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private String name;
    private static List<Item> itemInRoom = new ArrayList<Item>();
    private String description;
    protected static int idCounter = 0;
    protected int id;
    private boolean access;


    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public boolean getAccess() {
        return access;
    }

    public List<Item> getItemsInRoom() {
        return itemInRoom;
    }

    public String getDescription() {
        return description;
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
        if (itemInRoom.contains(item) && item != null) {
            itemInRoom.add(item);
        }
    }

    public abstract int neededItem();

    public String removeItem(Item item) {
        if (itemInRoom.contains(item) && item != null)
        {
            itemInRoom.remove(item);
            return "You picked up the Item";
        }
        return "You can't pick it up";
    }

}

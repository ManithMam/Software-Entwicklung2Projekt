package rooms;

import Items.Items;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private String name;
    private static List<Items> itemsInRoom = new ArrayList<Items>();
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

    public List<Items> getItemsInRoom() {
        return itemsInRoom;
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

    protected void addItemsInRoom(Items item) {
        if (itemsInRoom.contains(item) && item != null) {
            itemsInRoom.add(item);
        }
    }

    public abstract int neededItem();

    protected String removeItem(Items item) {
        if (itemsInRoom.contains(item) && item != null)
        {
            itemsInRoom.remove(item);
            return "You picked up the Item";
        }
        return "You can't pick it up";
    }

}

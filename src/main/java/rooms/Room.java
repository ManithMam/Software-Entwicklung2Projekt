package rooms;

import Items.Items;

import java.util.ArrayList;

public abstract class Room {

    private String name;
    private static ArrayList<Items> itemsInRoom = new ArrayList<Items>();      //TODO nachfragen ob es Sinn macht private zu halten, und dann über Setter auf die Attribute zuzugreifen
    private String description;
    private int id;                                                 //TODO nachfragen interface + vererbung oder nur interface etc
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

    public ArrayList<Items> getItemsInRoom() {
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

    protected void setId(int id) {
        this.id = id;
    }

    protected void addItemsInRoom(Items item) {
        if (itemsInRoom.contains(item) && item != null) {
            itemsInRoom.add(item);
        }
    }

    protected String removeItem(Items item) {
        if (itemsInRoom.contains(item) && item != null)  //&& if pickable = true
        {
            itemsInRoom.remove(item);
            return "You picked up the Item";
        }
        return "You can't pick it up";
    }

}

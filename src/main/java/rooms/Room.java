package rooms;
import classes.Items;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private String name;
    private ArrayList<Items> itemsInRoom = new ArrayList<Items>();      //TODO nachfragen ob es Sinn macht private zu halten, und dann über Setter auf die Attribute zuzugreifen
    private String description;










    public String getName() {
        return name;
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

    protected void addItemsInRoom(Items item)
    {
        if(itemsInRoom.contains(item) && item != null)
        {
            itemsInRoom.add(item);
        }
    }

    protected String removeItem(Items item)
    {
        if(itemsInRoom.contains(item) && item != null)  //&& if pickable = true
        {
            itemsInRoom.remove(item);
            return "You picked up the Item";
        }
        return "You can't pick it up";
    }
}

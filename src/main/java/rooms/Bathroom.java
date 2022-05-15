package rooms;

import classes.Items;

public class Bathroom extends Room{

    Items glasses = new Items();

    public Bathroom()
    {
        setName("Bathroom");
        setDescription("This is the Bathroom");
        addItemsInRoom(glasses);
    }
}

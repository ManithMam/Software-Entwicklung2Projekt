package rooms;

import classes.Items;

public class Hallway extends Room{

    Items carKey = new Items();

    public Hallway()
    {
        setName("Hallway");
        setDescription("It seems pretty empty");
        addItemsInRoom(carKey);
    }
}

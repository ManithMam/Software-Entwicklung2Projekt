package rooms;

import classes.Items;

public class Hallway extends Room{

    Items carKey = new Items();

    public Hallway()
    {
        setId(2);
        setAccess(true);
        setName("Hallway");
        setDescription("It seems pretty empty");
        addItemsInRoom(carKey);
    }
}

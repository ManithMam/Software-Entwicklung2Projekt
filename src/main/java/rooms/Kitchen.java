package rooms;

import classes.Items;

public class Kitchen extends Room{

    Items knife = new Items();

    public Kitchen()
    {
        setId(4);
        setAccess(true);
        setName("Kitchen");
        setDescription("Go cook something");
        addItemsInRoom(knife);
    }
}

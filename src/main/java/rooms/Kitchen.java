package rooms;

import classes.Items;

public class Kitchen extends Room{

    Items knife = new Items();

    public Kitchen()
    {
        setName("Kitchen");
        setDescription("Go cook something");
        addItemsInRoom(knife);
    }
}

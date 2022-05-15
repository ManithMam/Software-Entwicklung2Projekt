package rooms;

import classes.Items;

public class Library extends Room {

    Items cookbook = new Items();

    public Library()
    {
        setName("Library");
        setDescription("You should read something");
        addItemsInRoom(cookbook);
    }

}

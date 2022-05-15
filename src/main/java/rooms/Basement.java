package rooms;

import classes.Items;

public class Basement extends Room{

    Items baseballbat = new Items();
    Items kitchenKey = new Items();
    Items rope = new Items();

    public Basement()
    {
        setName("Basement");
        setDescription("This is the last Level");
        addItemsInRoom(baseballbat);
        addItemsInRoom(kitchenKey);
        addItemsInRoom(rope);
    }
}

package rooms;

import Items.Items;

public class Basement extends Room {

    private final Items baseballbat = new Items();
    private final Items kitchenKey = new Items();
    private final Items rope = new Items();

    public Basement() {
        setId(0);
        setAccess(true);
        setName("Basement");
        setDescription("This is the last Level");
        addItemsInRoom(baseballbat);
        addItemsInRoom(kitchenKey);
        addItemsInRoom(rope);
    }

    public int neededItem()
    {
        return 0;
    }
}

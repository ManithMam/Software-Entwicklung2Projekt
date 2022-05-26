package rooms;

import Items.Items;

public class Kitchen extends Room {

    private final Items knife = new Items();

    public Kitchen() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Kitchen");
        setDescription("Go cook something");
        addItemsInRoom(knife);
    }

    public int neededItem()
    {
        return 0;
    }
}

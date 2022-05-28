package rooms;

import items.Item;
import items.commonItems.Knife;

public class Kitchen extends Room {

    private final Item knife = new Knife();

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

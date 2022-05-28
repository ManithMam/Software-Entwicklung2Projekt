package rooms;

import items.Item;
import items.keyItems.CarKey;

public class Hallway extends Room {

    private final Item carKey = new CarKey();

    public Hallway() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Hallway");
        setDescription("It seems pretty empty");
        addItemsInRoom(carKey);
    }

    public int neededItem()
    {
        return 0;
    }
}

package rooms;

import Items.Items;

public class Hallway extends Room {

    private final Items carKey = new Items();

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

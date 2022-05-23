package rooms;

import Items.Items;

public class Kitchen extends Room {

    private final Items knife = new Items();

    public Kitchen() {
        setId(4);
        setAccess(true);
        setName("Kitchen");
        setDescription("Go cook something");
        addItemsInRoom(knife);
    }
}

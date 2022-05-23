package rooms;

import Items.Items;

public class Library extends Room {

    private final Items cookbook = new Items();
    private final Items libraryKey = new Items();

    public Library() {
        setId(3);
        setAccess(false);
        setName("Library");
        setDescription("You should read something");
        addItemsInRoom(cookbook);
    }

    public int neededItem()
    {
        return libraryKey.getId();
    }
}

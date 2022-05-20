package rooms;

import Items.Items;

public class Library extends Room {

    Items cookbook = new Items();
    Items libraryKey = new Items();

    public Library() {
        setId(3);
        setAccess(false);
        setName("Library");
        setDescription("You should read something");
        addItemsInRoom(cookbook);
    }


}

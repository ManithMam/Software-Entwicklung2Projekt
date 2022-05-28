package rooms;

import items.Item;
import items.commonItems.Cookbook;
import items.keyItems.LibraryKey;

public class Library extends Room {

    private final Item cookbook = new Cookbook();
    private final Item libraryKey = new LibraryKey();

    public Library() {
        this.id = ++idCounter;
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

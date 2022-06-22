package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.Cookbook;
import de.stuttgart_hdm.mi.se2.items.keyItems.LibraryKey;

public class Library extends Room {

    private final Item libraryKey = getKeyItemFactory().createItem("Library key");

    protected Library() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Library");
        setDescription("You should read something");

        final Item cookbook = getItemFactory().createItem("Cookbook");
        addItemsInRoom(cookbook);
        addItemsInRoom(libraryKey);
    }

    public int neededItem()
    {
        return libraryKey.getId();
    }
}

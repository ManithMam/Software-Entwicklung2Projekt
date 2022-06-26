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
        setDescription("I can probably find some useful information in the books.\nHere are three bookshelf all filled up to the brim.\nThat could take some time.");
        setDoorDescription("The door knob feels colder then my ex´s heart.\nThe knob looks frozen\nI can barely touch it now");
        final Item cookbook = getItemFactory().createItem("Cookbook");
        addItemsInRoom(cookbook);
        addItemsInRoom(libraryKey);
    }

    public int neededItem()
    {
        return libraryKey.getId();
    }
}

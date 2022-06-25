package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.Cookbook;
import de.stuttgart_hdm.mi.se2.items.keyItems.BathroomKey;
import de.stuttgart_hdm.mi.se2.items.keyItems.LibraryKey;

import java.util.ArrayList;
import java.util.List;

public class Library extends Room {

    //private final Item libraryKey = getKeyItemFactory().createItem("Library key");

    protected Library() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Library");
        setDescription("You should read something");

        final Item cookbook = getItemFactory().createItem("Cookbook");
        addItemsInRoom(cookbook);
        //addItemsInRoom(libraryKey);
    }

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(LibraryKey.class::isInstance).map(Item::getId).toList();
    }
}

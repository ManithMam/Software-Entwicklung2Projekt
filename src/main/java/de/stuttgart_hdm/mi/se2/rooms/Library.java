package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;

import de.stuttgart_hdm.mi.se2.items.commonItems.*;
import de.stuttgart_hdm.mi.se2.items.furniture.Chair;
import de.stuttgart_hdm.mi.se2.items.keyItems.KitchenTorch;
import de.stuttgart_hdm.mi.se2.items.keyItems.Knife;

import java.util.List;

/**
 * Inheritance from the abstract class Room
 * sets the properties through getters to keep encapsulation
 * Item objects are created in the constructor with the corresponding factory
 */

public class Library extends Room {


    protected Library() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Library");
        setDescription("I can probably find some useful information in the books.\nThere are three bookshelf all filled to the brim.\nThat could take some time.");
        setDoorDescription("The door knob feels colder then my ex´s heart.\nIt almost looks frozen\nI can barely touch it now");
        addItemsInRoom(getKeyItemList().stream().filter(Knife.class::isInstance).toList().get(0));
        addItemsInRoom(getFurnitureList().stream().filter(Chair.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Glasses.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Book.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Note4.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Note5.class::isInstance).toList().get(0));
    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(KitchenTorch.class::isInstance).map(Item::getId).toList();
    }
}

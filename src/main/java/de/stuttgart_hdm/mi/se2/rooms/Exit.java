package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.ExitKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Inheritance from the abstract class Room
 * sets the properties through getters to keep encapsulation
 * Item objects are created in the constructor with the corresponding factory
 */

public class Exit extends Room {


    protected Exit() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Exit");
        setDescription("I am finally free! Whatever the hell that was.\nI got my way once again.");
        setDoorDescription("It´s a heavy metal door with a huge lock.");
    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(ExitKey.class::isInstance).map(Item::getId).toList();
    }
}

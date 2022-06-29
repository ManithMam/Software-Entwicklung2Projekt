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
        setDescription("I am free!\nI can hear the birds singing.\nA fresh breeze caresses my nostrils");
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

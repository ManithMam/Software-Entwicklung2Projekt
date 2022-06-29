package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Inheritance from the abstract class Room
 * sets the properties through getters to keep encapsulation
 * Item objects are created in the constructor with the corresponding factory
 */

public class Hallway extends Room {

    protected Hallway() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Hallway");
        setDescription("The Hallway is really long.\n");
        setDoorDescription("The door is wide open");
        addItemsInRoom(getKeyItemList().stream().filter(BaseballBat.class::isInstance).toList().get(0));
        addItemsInRoom(getKeyItemList().stream().filter(Watch.class::isInstance).toList().get(0));

    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return new ArrayList<>();
    }
}

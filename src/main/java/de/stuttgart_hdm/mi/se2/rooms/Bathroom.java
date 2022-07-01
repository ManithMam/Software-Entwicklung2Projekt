package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.Note2;
import de.stuttgart_hdm.mi.se2.items.furniture.Sink;
import de.stuttgart_hdm.mi.se2.items.furniture.Toilet;
import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.Toothbrush;

import java.util.List;

/**
 * Inheritance from the abstract class Room
 * sets the properties through getters to keep encapsulation
 * Item objects are created in the constructor with the corresponding factory
 */

public class Bathroom extends Room {


    protected Bathroom() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Bathroom");
        setDescription("That´s not the time to take a crap!\nUgh!! It's so filthy in here.\nAnd pretty cramped on top of that.");
        setDoorDescription("It´s an old-fashioned wooden door.\nIt looks breakable");
        addItemsInRoom(getKeyItemList().stream().filter(Toothbrush.class::isInstance).toList().get(0));
        addItemsInRoom(getFurnitureList().stream().filter(Sink.class::isInstance).toList().get(0));
        addItemsInRoom(getFurnitureList().stream().filter(Toilet.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Note2.class::isInstance).toList().get(0));


    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(BaseballBat.class::isInstance).map(Item::getId).toList();
    }

}

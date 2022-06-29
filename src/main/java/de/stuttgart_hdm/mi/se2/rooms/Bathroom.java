package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
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
        setDescription("That´s not the time to take a crap!\nBah!! The toilet is disgusting and the sink is filthy.\nUnderneath it there is a cabinet placed. It´s pretty tight in here.");
        setDoorDescription("It´s a old-fashioned wooden door.\nIt looks breakable");
        addItemsInRoom(getKeyItemList().stream().filter(Toothbrush.class::isInstance).toList().get(0));
        final Item toilet = getFurnitureFactory().createFurniture("Toilet");
        final Item sink = getFurnitureFactory().createFurniture("Sink");
        addItemsInRoom(toilet);
        addItemsInRoom(sink);

    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(BaseballBat.class::isInstance).map(Item::getId).toList();
    }

}

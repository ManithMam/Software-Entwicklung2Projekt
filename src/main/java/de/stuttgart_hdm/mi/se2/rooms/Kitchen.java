package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.Cookbook;
import de.stuttgart_hdm.mi.se2.items.commonItems.Note3;
import de.stuttgart_hdm.mi.se2.items.commonItems.Pliers;
import de.stuttgart_hdm.mi.se2.items.keyItems.KitchenTorch;
import de.stuttgart_hdm.mi.se2.items.keyItems.Toothbrush;
import java.util.List;

/**
 * Inheritance from the abstract class Room
 * sets the properties through getters to keep encapsulation
 * Item objects are created in the constructor with the corresponding factory
 */

public class Kitchen extends Room {


    protected Kitchen() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Kitchen");
        setDescription("Ughh. A cruel and disgusting smell tries to creep up my nose.\nIt´s unbearable. Definitely no place to prepare food!");
        setDoorDescription("It´s a heavy sliding door.\nIt´s too sturdy to break it.\nBut maybe I can pick the lock.");
        addItemsInRoom(getKeyItemList().stream().filter(KitchenTorch.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Cookbook.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Note3.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Pliers.class::isInstance).toList().get(0));
    }


    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(Toothbrush.class::isInstance).map(Item::getId).toList();
    }
}

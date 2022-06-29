package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.ExitKey;
import de.stuttgart_hdm.mi.se2.items.keyItems.Knife;

import java.util.List;

/**
 * Inheritance from the abstract class Room
 * sets the properties through getters to keep encapsulation
 * Item objects are created in the constructor with the corresponding factory
 */


public class Basement extends Room {


    protected Basement() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Basement");
        setDescription("It´s pretty dark in here.\nI can barely see my own hand.\nI think something tries to crawl up my leg!\nBut it disappeared after a shake.");     //TODO Itemliste in room nicht anzeigen bis taschenlampe gefunden wurde
        setDoorDescription("It´s a heavy metal door.\nThere is no way you can break it, can you?");
        addItemsInRoom(getKeyItemList().stream().filter(ExitKey.class::isInstance).toList().get(0));
        final Item bed = getFurnitureFactory().createFurniture("Bed");
        final Item note2 = getItemFactory().createItem("Note2");
        addItemsInRoom(bed);
        addItemsInRoom(note2);
    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(BaseballBat.class::isInstance).map(Item::getId).toList();
    }
}

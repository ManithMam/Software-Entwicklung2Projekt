package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.Note6;
import de.stuttgart_hdm.mi.se2.items.furniture.Bed;
import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.ExitKey;
import de.stuttgart_hdm.mi.se2.items.keyItems.KitchenTorch;
import de.stuttgart_hdm.mi.se2.items.keyItems.Knife;

import java.util.ArrayList;
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
        setDescription("It´s pretty dark in here.\nI can barely see my own hand.\nI think something just tried to crawl up my leg!\nBut it disappeared after a shake.");     //TODO Itemliste in room nicht anzeigen bis taschenlampe gefunden wurde
        setDoorDescription("It´s a heavy metal door.\nThere is no way I can break it, can I?");
        addItemsInRoom(getKeyItemList().stream().filter(ExitKey.class::isInstance).toList().get(0));
        addItemsInRoom(getFurnitureList().stream().filter(Bed.class::isInstance).toList().get(0));
        addItemsInRoom(getItemList().stream().filter(Note6.class::isInstance).toList().get(0));
    }

    /**
     * @return a List of needed Items to access the room
     */
    public List<Integer> neededItem()
    {

        List<Integer> neededKeyItemList = new ArrayList<>();
        neededKeyItemList.addAll(getKeyItemList().stream().filter(BaseballBat.class::isInstance).map(Item::getId).toList());
        neededKeyItemList.addAll(getKeyItemList().stream().filter(Knife.class::isInstance).map(Item::getId).toList());
        neededKeyItemList.addAll(getKeyItemList().stream().filter(KitchenTorch.class::isInstance).map(Item::getId).toList());

        return neededKeyItemList;
    }
}

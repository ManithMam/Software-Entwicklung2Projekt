package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.ItemFactory;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import de.stuttgart_hdm.mi.se2.items.keyItems.BathroomKey;
import de.stuttgart_hdm.mi.se2.items.commonItems.Glasses;
import de.stuttgart_hdm.mi.se2.items.keyItems.KeyItemFactory;

import java.util.stream.Collectors;

public class Bathroom extends Room {

    //private final Item bathroomKey = getKeyItemFactory().createItem("Bathroom key");

    protected Bathroom() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Bathroom");
        setDescription("That´s not the time to take a crap!\nBah!! The toilet is disgusting and the sink is filthy.\nUnderneath it there is a cabinet placed. It´s pretty tight in here.");
        setDoorDescription("It´s a old-fashioned wooden door.\nIt looks breakable");
        final Item glasses = getItemFactory().createItem("Glasses");
        addItemsInRoom(glasses);
        //addItemsInRoom(bathroomKey);

    }

    public int neededItem()
    {
        return getKeyItemList().stream().filter(item -> item.getName() == "Aluminum Baseball bat").collect(Collectors.toList()).get(0).getId();
    }

}

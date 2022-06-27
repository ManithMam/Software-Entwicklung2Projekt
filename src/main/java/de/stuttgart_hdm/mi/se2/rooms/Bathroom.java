package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BathroomKey;

import java.util.List;

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

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(BathroomKey.class::isInstance).map(Item::getId).toList();
    }

}

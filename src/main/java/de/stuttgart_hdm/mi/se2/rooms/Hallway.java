package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.CarKey;

import java.util.stream.Collectors;

public class Hallway extends Room {

    //private final Item bathroomKey = getKeyItemFactory().createItem("Bathroom key");

    protected Hallway() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Hallway");
        setDescription("The Hallway is really long.\nThere is grandfather clock in the end.");
        setDoorDescription("The door is wide open");
        addItemsInRoom(getKeyItemList().stream().filter(item -> item.getName() == "Aluminum Baseball bat").collect(Collectors.toList()).get(0));
    }

    public int neededItem()
    {
        return 0;
    }
}

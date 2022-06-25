package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BathroomKey;
import de.stuttgart_hdm.mi.se2.items.keyItems.CarKey;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hallway extends Room {

    //private final Item bathroomKey = getKeyItemFactory().createItem("Bathroom key");

    protected Hallway() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Hallway");
        setDescription("It seems pretty empty");
        addItemsInRoom(getKeyItemList().stream().filter(BathroomKey.class::isInstance).toList().get(0));
    }

    public List<Integer> neededItem()
    {
        return new ArrayList<>();
    }
}

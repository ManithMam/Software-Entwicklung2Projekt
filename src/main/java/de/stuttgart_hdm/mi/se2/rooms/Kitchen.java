package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.KitchenKey;

import java.util.List;

public class Kitchen extends Room {

    //private final Item kitchenKey = getKeyItemFactory().createItem("Kitchen key");

    protected Kitchen() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Kitchen");
        setDescription("Go cook something");

        final Item knife = getItemFactory().createItem("Knife");
        addItemsInRoom(knife);
        //addItemsInRoom(kitchenKey);
    }

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(KitchenKey.class::isInstance).map(Item::getId).toList();
    }
}

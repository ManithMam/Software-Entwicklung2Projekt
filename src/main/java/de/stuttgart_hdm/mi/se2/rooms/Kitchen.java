package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.commonItems.Knife;

public class Kitchen extends Room {

    private final Item kitchenKey = getKeyItemFactory().createItem("Kitchen key");

    protected Kitchen() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Kitchen");
        setDescription("Uhhh. A cruel and disgusting smell tries to creep up my nose.\nIt´s not bearable. I am pretty sure something died here not only once.");
        setDoorDescription("It´s a heavy sliding door.\nIt´s too sturdy to break it.\nBut maybe I can pick the lock");
        final Item knife = getItemFactory().createItem("Knife");
        addItemsInRoom(knife);
        addItemsInRoom(kitchenKey);
    }

    public int neededItem()
    {
        return kitchenKey.getId();
    }
}

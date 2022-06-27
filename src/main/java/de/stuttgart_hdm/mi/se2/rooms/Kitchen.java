package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.KitchenTorch;
import de.stuttgart_hdm.mi.se2.items.keyItems.Toothbrush;

import java.util.List;

public class Kitchen extends Room {


    protected Kitchen() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Kitchen");
        setDescription("Uhhh. A cruel and disgusting smell tries to creep up my nose.\nIt´s not bearable. I am pretty sure something died here not only once.");
        setDoorDescription("It´s a heavy sliding door.\nIt´s too sturdy to break it.\nBut maybe I can pick the lock");
        addItemsInRoom(getKeyItemList().stream().filter(KitchenTorch.class::isInstance).toList().get(0));
        final Item cookbook = getItemFactory().createItem("Cookbook");
        addItemsInRoom(cookbook);
    }

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(Toothbrush.class::isInstance).map(Item::getId).toList();
    }
}

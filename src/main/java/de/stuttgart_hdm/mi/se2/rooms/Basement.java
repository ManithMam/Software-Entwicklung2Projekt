package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;


public class Basement extends Room {

    //private final Item kitchenKey = getKeyItemFactory().createItem("Kitchen key");

    protected Basement() {
        this.id = ++idCounter;
        setAccess(true);
        setName("Basement");
        setDescription("This is the last Level");

        final Item baseballbat = getItemFactory().createItem("BaseballBat");
        final Item rope = getItemFactory().createItem("Rope");
        addItemsInRoom(baseballbat);
        //addItemsInRoom(kitchenKey);
        addItemsInRoom(rope);
    }

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(BathroomKey.class::isInstance).map(Item::getId).toList();
    }
}

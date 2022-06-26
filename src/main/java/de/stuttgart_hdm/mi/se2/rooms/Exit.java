package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Exit extends Room {

    private final Item kitchenKey = getKeyItemFactory().createItem("Kitchen key");

    protected Exit() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Exit");
        setDescription("I am free!\nI can hear the birds singing.\nA fresh breeze caresses my nostrils");
        setDoorDescription("It´s a heavy metal door with a huge lock.");
    }

    public int neededItem()
    {
        return kitchenKey.getId();
    }
}

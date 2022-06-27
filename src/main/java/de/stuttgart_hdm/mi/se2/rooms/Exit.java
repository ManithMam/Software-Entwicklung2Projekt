package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BaseballBat;
import de.stuttgart_hdm.mi.se2.items.keyItems.ExitKey;

import java.util.ArrayList;
import java.util.List;

public class Exit extends Room {


    protected Exit() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Exit");
        setDescription("I am free!\nI can hear the birds singing.\nA fresh breeze caresses my nostrils");
        setDoorDescription("It´s a heavy metal door with a huge lock.");
    }

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(ExitKey.class::isInstance).map(Item::getId).toList();
    }
}

package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.keyItems.BathroomKey;


public class Basement extends Room {


    protected Basement() {

            this.id = ++idCounter;
            setAccess(false);
            setName("Basement");
            setDescription("It´s pretty dark in here.\nI can barely see my own hand.\nI think something tries to crawl up my leg!\nBut it disappeared after a shake.");     //TODO Itemliste in room nicht anzeigen bis taschenlampe gefunden wurde
            setDoorDescription("It´s a heavy metal door.\nThere is no way you can break it, can you?");
            final Item rope = getItemFactory().createItem("Rope");
            addItemsInRoom(getKeyItemList().stream().filter(BathroomKey.class::isInstance).toList().get(0));
            addItemsInRoom(rope);
    }

    public int neededItem()
    {
        return 0;
    }
}

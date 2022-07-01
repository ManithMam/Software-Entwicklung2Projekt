package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Book extends Item {

    protected Book(){
        this.id = ++idCount;
        setName("Book in shelf");
        setDesc("\"Java for dummies\"...\nI think I know someone who needs it.");
        setPickable(false);
        itemList.add(this);
    }

}

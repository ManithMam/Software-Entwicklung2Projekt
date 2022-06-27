package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Clock extends Item {

    protected Clock(){
        this.id = ++idCount;
        setName("Clock");
        setPickable(true);
        setDesc("It's still ticking! No idea if the time is accurate tho...");
        furnitureList.add(this);
    }

}

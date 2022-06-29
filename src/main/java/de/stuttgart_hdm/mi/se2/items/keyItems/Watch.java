package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Watch extends Item {

    protected Watch(){
        this.id = ++idCount;
        setName("Watch");
        setPickable(true);
        setDesc("It's still ticking! No idea if the time is accurate tho...");
        furnitureList.add(this);
    }

}

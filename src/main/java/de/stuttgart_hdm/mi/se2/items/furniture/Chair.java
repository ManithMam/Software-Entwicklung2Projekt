package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Chair extends Item {

    protected Chair(){
        this.id = ++idCount;
        setName("Chair");
        setPickable(false);
        setDesc("Doesn't look too comfortable");
        furnitureList.add(this);
    }

}

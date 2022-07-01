package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class CD extends Item {

    protected CD(){
        this.id = ++idCount;
        setName("CD");
        setDesc("\"JBG2\", now that's the real deal");
        setPickable(true);
        itemList.add(this);
    }

}

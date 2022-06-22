package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Glasses extends Item {

    protected Glasses(){
        this.id = ++idCount;
        setName("Glasses");
        setDesc("Maybe with these I could understand what I saw in her");
        setPickable(true);
        itemList.add(this);
    }

}

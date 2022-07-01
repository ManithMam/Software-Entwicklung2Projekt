package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Rope extends Item {

    protected Rope(){
        this.id = ++idCount;
        setName("Rope");
        setDesc("A pretty strong rope that could be useful later");
        setPickable(true);
        itemList.add(this);
    }

}

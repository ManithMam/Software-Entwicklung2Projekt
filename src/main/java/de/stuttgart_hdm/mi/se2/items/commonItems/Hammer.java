package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Hammer extends Item {

    protected Hammer(){
        this.id = ++idCount;
        setName("Rope");
        setDesc("A strong rope that could be useful later");
        setPickable(true);
        itemList.add(this);
    }

}

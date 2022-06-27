package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Pliers extends Item {

    protected Pliers(){
        this.id = ++idCount;
        setName("Pliers");
        setDesc("Some pretty decent pliers.");
        setPickable(true);
        itemList.add(this);
    }

}

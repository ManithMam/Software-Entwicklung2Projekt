package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Knife extends Item {

    protected Knife(){
        this.id = ++idCount;
        setName("Rusty Knife");
        setDesc("Looks way too rusty to be usable.");
        setPickable(true);
        itemList.add(this);
    }

}

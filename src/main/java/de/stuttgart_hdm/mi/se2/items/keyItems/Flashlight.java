package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Flashlight extends Item {

    protected Flashlight(){
        this.id = ++idCount;
        setName("Flashlight");
        setDesc("A small flashlight. \nI think it still works!");
        setPickable(true);
        itemList.add(this);
    }

}

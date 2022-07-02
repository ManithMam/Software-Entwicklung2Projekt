package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Flashlight extends Item {

    /**
     * Inheritance from abstract class Item
     * KeyItem properties set through getters to keep encapsulation
     * Item to be used to get access to items in basement
     */

    protected Flashlight(){
        this.id = ++idCount;
        setName("Flashlight");
        setDesc("A small flashlight. \nI think it still works!");
        setPickable(true);
        itemList.add(this);
    }

}

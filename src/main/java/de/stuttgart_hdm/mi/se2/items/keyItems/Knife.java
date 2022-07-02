package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Knife extends Item {

    /**
     * Inheritance from abstract class Item
     * KeyItem properties set through getters to keep encapsulation
     * Item to be used to get access to a door
     */

    protected Knife(){
        this.id = ++idCount;
        setName("Rusty Knife");
        setDesc("Looks way too rusty to be usable.");
        setPickable(true);
        itemList.add(this);
    }

}

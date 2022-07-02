package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class ExitKey extends Item {

    /**
     * Inheritance from abstract class Item
     * KeyItem properties set through getters to keep encapsulation
     * Item to be used to get access to a door
     */

    protected ExitKey(){
        this.id = ++idCount;
        setName("Large Key");
        setDesc("A large old key.\nLooks like it's opening something important.");
        setPickable(true);
        itemList.add(this);
    }

}

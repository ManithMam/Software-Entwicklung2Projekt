package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Toothbrush extends Item {

    /**
     * Inheritance from abstract class Item
     * KeyItem properties set through getters to keep encapsulation
     * Item to be used to get access to a door
     */

    protected Toothbrush(){
        this.id = ++idCount;
        setName("Broken toothbrush");
        setDesc("A broken pointy toothbrush...\nWho on earth keeps this around!?");
        setPickable(true);
        itemList.add(this);
    }

}

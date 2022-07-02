package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Rope extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Rope(){
        this.id = ++idCount;
        setName("Rope");
        setDesc("A pretty strong rope that could be useful later");
        setPickable(true);
        itemList.add(this);
    }

}

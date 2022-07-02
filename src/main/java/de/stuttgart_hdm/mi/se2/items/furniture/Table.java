package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Table extends Item {

    /**
     * Inheritance from abstract class Item
     * Furniture properties set through getters to keep encapsulation
     * Boolean Pickable always set to false
     */

    protected Table(){
        this.id = ++idCount;
        setName("Table");
        setPickable(false);
        setDesc("A sturdy wooden table");
        furnitureList.add(this);
    }

}

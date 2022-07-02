package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Bed extends Item {

    /**
     * Inheritance from abstract class Item
     * Furniture properties set through getters to keep encapsulation
     * Boolean Pickable always set to false
     */

    protected Bed(){
        this.id = ++idCount;
        setName("Bed");
        setPickable(false);
        setDesc("Looks like someone died on this...");
        furnitureList.add(this);
    }

}

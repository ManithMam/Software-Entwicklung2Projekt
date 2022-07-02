package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Toilet extends Item {

    /**
     * Inheritance from abstract class Item
     * Furniture properties set through getters to keep encapsulation
     * Boolean Pickable always set to false
     */

    protected Toilet(){
        this.id = ++idCount;
        setName("Toilet");
        setPickable(false);
        setDesc("I'm definitely not sitting on that!");
        furnitureList.add(this);
    }

}

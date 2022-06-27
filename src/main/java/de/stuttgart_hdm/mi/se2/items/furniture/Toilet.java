package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Toilet extends Item {

    protected Toilet(){
        this.id = ++idCount;
        setName("Toilet");
        setPickable(false);
        setDesc("I'm definitely not sitting on that!");
        furnitureList.add(this);
    }

}

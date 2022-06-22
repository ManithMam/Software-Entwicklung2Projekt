package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class CarKey extends Item {

    protected CarKey(){
        this.id = ++idCount;
        setName("Car key");
        setDesc("A key to my Benz AMG");
        setPickable(true);
        itemList.add(this);
    }

}

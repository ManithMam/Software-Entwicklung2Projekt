package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class KitchenKey extends Item {

    protected KitchenKey(){
        this.id = ++idCount;
        setName("Kitchen key");
        setDesc("A key to access the kitchen");
        setPickable(true);
        itemList.add(this);
    }

}

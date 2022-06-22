package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Knife extends Item {

    protected Knife(){
        this.id = ++idCount;
        setName("Knife");
        setDesc("Looks barely sharp enough to cut an apple");
        setPickable(true);
        itemList.add(this);
    }

}

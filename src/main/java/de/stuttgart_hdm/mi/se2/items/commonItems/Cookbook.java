package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Cookbook extends Item {

    protected Cookbook(){
        this.id = ++idCount;
        setName("Cookbook");
        setDesc("A book full of tasty recipes");
        setPickable(true);
        itemList.add(this);
    }

}

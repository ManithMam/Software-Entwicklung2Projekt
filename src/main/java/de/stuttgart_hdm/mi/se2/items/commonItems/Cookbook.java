package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Cookbook extends Item {

    protected Cookbook(){
        this.id = ++idCount;
        setName("Cookbook");
        setDesc("That fried rice sure looks good...\nI'm getting distracted...\nand hungry.");
        setPickable(false);
        itemList.add(this);
    }

}

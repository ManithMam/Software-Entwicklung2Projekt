package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Cookbook extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Cookbook(){
        this.id = ++idCount;
        setName("Cookbook");
        setDesc("That fried rice sure looks good...\nI'm getting distracted...\nand hungry.");
        setPickable(false);
        itemList.add(this);
    }

}

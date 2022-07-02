package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class BaseballBat extends Item {

    /**
     * Inheritance from abstract class Item
     * KeyItem properties set through getters to keep encapsulation
     * Item to be used to get access to a door
     */

    protected BaseballBat(){
        this.id = ++idCount;
        setName("Aluminum Baseball bat");
        setDesc("An old baseball bat made out of Aluminum.\nA strong negotiation device!");
        setPickable(true);
        itemList.add(this);
    }

}

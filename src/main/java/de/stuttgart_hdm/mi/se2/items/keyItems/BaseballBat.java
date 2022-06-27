package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class BaseballBat extends Item {

    protected BaseballBat(){
        this.id = ++idCount;
        setName("Aluminum Baseball bat");
        setDesc("A baseball bat made out of Aluminum.\nA strong negotiation device!");
        setPickable(true);
        itemList.add(this);
    }

}

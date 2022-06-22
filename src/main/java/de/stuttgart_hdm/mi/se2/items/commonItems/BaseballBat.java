package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class BaseballBat extends Item {

    protected BaseballBat(){
        this.id = ++idCount;
        setName("Baseball bat");
        setDesc("A strong negotiation device");
        setPickable(true);
        itemList.add(this);
    }

}

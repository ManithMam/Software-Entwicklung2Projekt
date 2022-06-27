package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class KitchenTorch extends Item {

    protected KitchenTorch(){
        this.id = ++idCount;
        setName("Kitchen torch");
        setDesc("Could be used as a pretty good lighter");
        setPickable(true);
        itemList.add(this);
    }

}

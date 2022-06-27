package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note3 extends Item {

    protected Note3(){
        this.id = ++idCount;
        setName("Note3");
        setDesc("A strong negotiation device");
        setPickable(false);
        itemList.add(this);
    }

}

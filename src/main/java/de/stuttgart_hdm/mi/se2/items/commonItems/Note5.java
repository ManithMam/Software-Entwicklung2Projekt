package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note5 extends Item {

    protected Note5(){
        this.id = ++idCount;
        setName("Note5");
        setDesc("A strong negotiation device");
        setPickable(false);
        itemList.add(this);
    }

}

package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note4 extends Item {

    protected Note4(){
        this.id = ++idCount;
        setName("Note4");
        setDesc("A strong negotiation device");
        setPickable(false);
        itemList.add(this);
    }

}

package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note5 extends Item {

    protected Note5(){
        this.id = ++idCount;
        setName("Opened chemistry book");
        setDesc("A page about thermite is lying open.\n A really weird person must live here.");
        setPickable(false);
        itemList.add(this);
    }

}

package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note1 extends Item {

    protected Note1(){
        this.id = ++idCount;
        setName("Piece of Paper");
        setDesc("\"");
        setPickable(false);
        itemList.add(this);
    }

}

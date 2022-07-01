package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note4 extends Item {

    protected Note4(){
        this.id = ++idCount;
        setName("Note between books");
        setDesc("\"...her heart burns with passion, every step she takes.\nA light she ignites, no darkness survives.\"\n");
        setPickable(false);
        itemList.add(this);
    }

}

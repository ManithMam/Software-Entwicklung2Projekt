package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note6 extends Item {

    protected Note6(){
        this.id = ++idCount;
        setName("Ripped note");
        setDesc("\"Aluminum + iron oxide = termite\"...\nWhat a weird note to keep around.");
        setPickable(false);
        itemList.add(this);
    }

}

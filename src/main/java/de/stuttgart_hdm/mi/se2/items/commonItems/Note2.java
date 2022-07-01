package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note2 extends Item {

    protected Note2(){
        this.id = ++idCount;
        setName("Ragged piece of paper");
        setDesc("\"A maiden grown old, her silver hair shines,\nher beauty remains, no one can deny...\"\nis this some kind of riddle?");
        setPickable(false);
        itemList.add(this);
    }

}

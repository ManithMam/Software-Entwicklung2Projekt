package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note6 extends Item {

    protected Note6(){
        this.id = ++idCount;
        setName("Diary");
        setDesc("\"Will he find the key? Will he ever escape?\nI truly wished there was a way around this...\"\nA way around what? Can't even tell your diary?");
        setPickable(false);
        itemList.add(this);
    }

}

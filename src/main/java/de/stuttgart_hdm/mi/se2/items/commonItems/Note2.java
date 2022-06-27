package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note2 extends Item {

    protected Note2(){
        this.id = ++idCount;
        setName("Diary");
        setDesc("\"...One after another... My collection\nwill soon be complete!...\"\nThey better be talking about Pokemon!");
        setPickable(false);
        itemList.add(this);
    }

}

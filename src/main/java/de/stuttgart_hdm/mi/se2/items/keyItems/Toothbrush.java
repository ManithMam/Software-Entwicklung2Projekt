package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Toothbrush extends Item {

    protected Toothbrush(){
        this.id = ++idCount;
        setName("Broken toothbrush");
        setDesc("A broken toothbrush...\nWho on earth keeps this around!?");
        setPickable(true);
        itemList.add(this);
    }

}

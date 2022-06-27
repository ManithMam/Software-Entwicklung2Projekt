package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Sink extends Item {

    protected Sink(){
        this.id = ++idCount;
        setName("Sink");
        setPickable(false);
        setDesc("If I wash my hands here\n they'll be dirtier than before!");
        furnitureList.add(this);
    }

}

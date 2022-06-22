package de.stuttgart_hdm.mi.se2.items.furniture;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Table extends Item {

    protected Table(){
        this.id = ++idCount;
        setName("Table");
        setPickable(false);
        setDesc("A sturdy wooden table");
        furnitureList.add(this);
    }

}

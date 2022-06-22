package de.stuttgart_hdm.mi.se2.items.furniture;


import de.stuttgart_hdm.mi.se2.items.Item;

public class Sofa extends Item {

    protected Sofa(){
        this.id = ++idCount;
        setName("Sofa");
        setPickable(false);
        setDesc("I could rest here for a while");
        furnitureList.add(this);
    }

}

package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class BathroomKey extends Item {

    protected BathroomKey(){
        this.id = ++idCount;
        setName("Aluminum Baseball bat");
        setDesc("A baseball bat made out of Aluminum.\nCould be used to smash in wooden Doors.");
        setPickable(true);
        itemList.add(this);
    }

}

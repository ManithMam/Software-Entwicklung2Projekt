package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note5 extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Note5(){
        this.id = ++idCount;
        setName("Chemistry book");
        setDesc("A page about thermite is lying open.\n What kind of person lives here?");
        setPickable(false);
        itemList.add(this);
    }

}

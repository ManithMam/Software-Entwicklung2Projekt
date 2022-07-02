package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note3 extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Note3(){
        this.id = ++idCount;
        setName("Paper pinned to wall");
        setDesc("\"...her skin full of wrinkles, all past her prime,\nher legs shaky, don't carry her like before...\"\nWhat the hell is that supposed to mean?");
        setPickable(false);
        itemList.add(this);
    }

}

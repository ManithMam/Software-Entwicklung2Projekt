package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note2 extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Note2(){
        this.id = ++idCount;
        setName("Ragged piece of paper");
        setDesc("\"A lady grown old, her silver hair shines,\nshe gets her way, with no one to deny...\"\nis this some kind of riddle?");
        setPickable(false);
        itemList.add(this);
    }

}

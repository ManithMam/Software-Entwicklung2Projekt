package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note1 extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Note1(){
        this.id = ++idCount;
        setName("Letter");
        setDesc("What's this? \"Try your best, you can never escape!\nIf you still intend, the time runs.\" This ain't funny!\n I better get going quick!");
        setPickable(false);
        itemList.add(this);
    }

}
